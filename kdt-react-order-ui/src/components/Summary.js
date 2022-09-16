import {SummaryItem} from "./SummaryItem";
import React, {useState} from "react";

export function Summary({items = [], onOrderSubmit}) {                       // items의 디폴트 값을 준다.
    const totalPrice = items.reduce((prev, curr) => prev + (curr.price * curr.count), 0);          // 이전 총금액과 현재의 총금액 합산
    //주문 정보 : 사용자 입력에 대한 상태관리 필요
    const [order, setOrder] = useState({                                             //필드로 정의한 뒤 각 input태그와 연결
        email: "", address: "", postcode: ""
    });

    const handleEmailInputChanged = (e) => {setOrder({...order, email: e.target.value})}  // onChange시마다 받는 콜백함수 연결
    const handleAddressInputChanged = (e) => {setOrder({...order, address: e.target.value})}
    const handlePostcodeInputChanged = (e) => {setOrder({...order, postcode: e.target.value})}
    const handleSubmit = (e) => {
        if (order.address === "" || order.email === "" || order.postcode === "") {
            alert("입력값을 확인해주세요!")
        } else {
            onOrderSubmit(order);
        }
    }
    return (
        <>
            <div>
                <h5 className='m-0 p-0'><b>Summary</b></h5>
            </div>
            <hr/>
            {items.map(v =>
                <SummaryItem key={v.productId} count={v.count} productName={v.productName}/>)}
            <form>
                <div className='mb-3'>
                    <label htmlFor='email' className='form-label'>이메일</label>
                    <input type='email' className='form-control mb-1' value={order.email} onChange={handleEmailInputChanged}
                           id='email'/>
                </div>
                <div className='mb-3'>
                    <label htmlFor='address' className='form-label'>주소</label>
                    <input type='text' className='form-control mb-1' value={order.address} onChange={handleAddressInputChanged}
                           id='address'/>
                </div>
                <div className='mb-3'>
                    <label htmlFor='postcode' className='form-label'>우편번호</label>
                    <input type='text' className='form-control' value={order.postcode} onChange={handlePostcodeInputChanged}
                           id='postcode'/>
                </div>
                <div>당일 오후 2시 이후의 주문은 다음날 배송을 시작합니다.</div>
            </form>
            <div className='row pt-2 pb-2 border-top'>
                <h5 className='col'>총금액</h5>
                <h5 className='col text-end'>{totalPrice}원</h5>
            </div>
            <button className='btn btn-dark col-12' onClick={handleSubmit}> 결제하기</button>
        </>
    );
}