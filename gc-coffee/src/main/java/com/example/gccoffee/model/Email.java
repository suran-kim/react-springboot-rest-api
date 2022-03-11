package com.example.gccoffee.model;

import org.springframework.util.Assert;

import java.util.Objects;
import java.util.regex.Pattern;

public class Email {

    private final String address;

    // 생성자 ---------------------------
    public Email(String address){
        Assert.notNull(address, "address should not be null"); // 이메일이 null이다.  -> Validation 실패 시 메세지 출력
        Assert.isTrue(address.length() >= 4 && address.length() <= 50, "address length must be between 4 and 50 characters."); // 이메일 길이가 맞지 않다.
        Assert.isTrue(checkAddress(address), "Invalid email address"); // 이메일 포맷에 맞지 않다. -> 정규표현식 사용 검증
        this.address = address;
    }

    // 이메일 포맷 검증 ------------------
    private static boolean checkAddress(String address) {
        return Pattern.matches("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b", address); // 정규표현식으로 검증
    }


    // equal() and hashCode() -> Value Object 구현 시 꼭 구현해주는 게 좋다.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(address, email.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    // toString -------------------------------------------
    @Override
    public String toString() {
        return "Email{" +
                "address='" + address + '\'' +
                '}';
    }

    // validation test를 위한 Getter
    public String getAddress() {
        return address;
    }
}
