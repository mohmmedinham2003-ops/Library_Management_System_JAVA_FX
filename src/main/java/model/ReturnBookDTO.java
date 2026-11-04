package model;

import java.time.LocalDate;

public class ReturnBookDTO {
    private Integer cmbBookId;
    private Integer cmbMemberId;
    private String phoneNumber;
    private String address;
    private LocalDate borrowedDate;
    private LocalDate dueDate;
    private LocalDate returnedDate;

    public ReturnBookDTO() {
    }

    public ReturnBookDTO(Integer cmbBookId, Integer cmbMemberId, String phoneNumber, String address, LocalDate borrowedDate, LocalDate dueDate, LocalDate returnedDate) {
        this.cmbBookId = cmbBookId;
        this.cmbMemberId = cmbMemberId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
        this.returnedDate = returnedDate;
    }

    @Override
    public String toString() {
        return "ReturnBookDTO{" +
                "cmbBookId=" + cmbBookId +
                ", cmbMemberId=" + cmbMemberId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", borrowedDate=" + borrowedDate +
                ", dueDate=" + dueDate +
                ", returnedDate=" + returnedDate +
                '}';
    }

    public Integer getCmbBookId() {
        return cmbBookId;
    }

    public void setCmbBookId(Integer cmbBookId) {
        this.cmbBookId = cmbBookId;
    }

    public Integer getCmbMemberId() {
        return cmbMemberId;
    }

    public void setCmbMemberId(Integer cmbMemberId) {
        this.cmbMemberId = cmbMemberId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }
}
