import './App.css'
import 'bootstrap/dist/css/bootstrap.css'
import React, {useState} from 'react';
import {ProductList} from "./components/ProductList";
import {Summary} from "./components/Summary";

export default App;


function App() {
    // 주문할 수 있는 상품 목록
    const [products, setProducts] = useState([ // 인자가 두 개인 배열 반환 => distructure
        {id: 'uuid-1', productName: '콜롬비아 커피1', category: '커피빈', price: 5000},
        {id: 'uuid-2', productName: '콜롬비아 커피2', category: '커피빈', price: 5000},
        {id: 'uuid-3', productName: '콜롬비아 커피3', category: '커피빈', price: 5000},
    ]);
    // 이미 주문한 상품 목록
    const [items, setItems] = useState([]); // handleAddClicked -> 상태 변경
    const handleAddClicked = id => {
        const product = products.find(v => v.id == id);
        const found = items.find(v => v.id == id);
        // 주목 목록에 id가 일치하는 item이 있는지 확인하고 있으면 count를 증가시킨다. 없으면 id가 일치하는 product를 추가하고 count를 증가시킨다.
        const updatedItems =
            found ? items.map(v => (v.id == id) ? {...v, count: v.count + 1} : v) : [...items, { ...product, count: 1}]
        setItems(updatedItems);
        console.log(products.find(v => v.id == id), "added!"); // state에서 해당 정보를 가져오는 코드
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
                        <Summary items={items}/>
                    </div>
                </div>
            </div>
        </div>
    );
}

