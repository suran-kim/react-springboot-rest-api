import './App.css'
import 'bootstrap/dist/css/bootstrap.css'
import React, {useEffect, useState} from 'react';
import {ProductList} from "./components/ProductList";
import {Summary} from "./components/Summary";
import axios from "axios";

export default App;


function App() {
    // 주문할 수 있는 상품 목록
    const [products, setProducts] = useState([ // 인자가 두 개인 배열 반환 => distructure
        {productId: 'uuid-1', productName: '콜롬비아 커피1', category: '커피빈', price: 5000},
        {productId: 'uuid-2', productName: '콜롬비아 커피2', category: '커피빈', price: 5000},
        {productId: 'uuid-3', productName: '콜롬비아 커피3', category: '커피빈', price: 5000},
    ]);
    // 이미 주문한 상품 목록
    const [items, setItems] = useState([]); // handleAddClicked -> 상태 변경
    const handleAddClicked = productId => {
        const product = products.find(v => v.productId === productId);
        const found = items.find(v => v.productId === productId);
        // 주목 목록에 id가 일치하는 item이 있는지 확인하고 있으면 count를 증가시킨다. 없으면 id가 일치하는 product를 추가하고 count를 증가시킨다.
        const updatedItems =
            found ? items.map(v => (v.productId === productId) ? {
                ...v,
                count: v.count + 1
            } : v) : [...items, {...product, count: 1}]
        setItems(updatedItems);
        console.log(products.find(v => v.productId === productId), "added!"); // state에서 해당 정보를 가져오는 코드
    }

    // 렌더링이 끝나면(상태가 바뀌면) 호출
    useEffect(() => {
        // 비동기 작업 진행
        axios.get('http://localhost:8080/api/v1/products')
            .then(v => setProducts(v.data));  // 서버로부터 데이터를 가져온다.
    }, []);

    const handleOrderSubmit = (order) => {
        // 주문 items 여부 판단
        if (items.length === 0) {
            alert("아이템을 추가해 주세요!");
        } else {
            // 비동기 통신 작업 진행

            axios.post('http://localhost:8080/api/v1/orders', {      //  데이터 매핑 처리
                email: order.email,
                address: order.address,
                postcode: order.postcode,
                orderItems: items.map(v => ({
                    productId: v.productId,
                    category: v.category,
                    price: v.price,
                    quantity: v.count
                }))
            }).then(v => alert("주문이 정상적으로 접수되었습니다."),
                e => {
                    alert("서버장애");
                    console.error(e);
                })
        }
    }

    return (<div className='container-fluid'>
            <div className='row justify-content-center m-4'>
                <h1 className='text-center'>Grids & Circle</h1>
            </div>
            <div className='card'>
                <div className='row'>
                    <div className='col-md-8 mt-4 d-flex flex-column align-items-start p-3 pt-0'>
                        <ProductList products={products} onAddClick={handleAddClicked}/>
                    </div>
                    <div className='col-md-4 summary p-4'>
                        <Summary items={items} onOrderSubmit={handleOrderSubmit}/>
                    </div>
                </div>
            </div>
        </div>
    );
}

