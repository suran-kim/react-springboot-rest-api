import React from "react";
import {Product} from "./Product";

export function ProductList({products = [], onAddClick}) { // {} : 객체 정의 문법. => props 내부에 products가 존재한다는 뜻이 된다.
    return (
        <React.Fragment>
            <h5 className='flex-grow-0'><b>상품 목록</b></h5>
            <ul className='list-group products'>
                {/* products 수만큼 반복 */}
                {products.map((v) => (
                    <li key={v.productId} className='list-group-item d-flex mt-3'> {/* map을 돌 때 key가 필요 */}
                        <Product {...v} onAddClick={onAddClick}/>
                    </li>
                ))}
            </ul>
        </React.Fragment>
    );
}