import React from "react";

export function Product(props) {
    const productName = props.productName;
    const category = props.category;
    const price = props.price;
    return (
        <>
            {/* product 개별 상품의 상세 정보 */}
            <div className='col-2'><img className='img-fluid' src='https://i.imgur.com/HKOFQYa.jpeg' alt=''/>
            </div>
            <div className='col'>
                <div className='row text-muted'>{category}</div>
                <div className='row'>{productName}</div>
            </div>
            <div className='col text-center price'>{price}원</div>
            <div className='col text-end action'>
                <button className='btn btn-small btn-outline-dark'>추가</button>
            </div>
        </>
    );
}