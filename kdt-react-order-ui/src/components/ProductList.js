import React from "react";
import {Product} from "./Product";

export function ProductList({products = []}) { // {} : 객체 정의 문법. => props 내부에 products가 존재한다는 뜻이 된다.
    return (
        <React.Fragment>
            <h5 className='flex-grow-0'><b>상품 목록</b></h5>
            <ul className='list-group products'>
                {/* products 수만큼 반복 */}
                {products.map((v) => (
                    <li key={v.id} className='list-group-item d-flex mt-3'> {/* map을 돌 때 key가 필요 */}
                        <Product productName={v.productName} category={v.category}
                                 price={v.price}/> {/*product 컴포넌트에 전달*/}
                    </li>
                ))}
            </ul>
        </React.Fragment>
    );
}