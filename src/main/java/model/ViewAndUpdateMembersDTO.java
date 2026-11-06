package model;

public class ViewAndUpdateMembersDTO {
    private Integer cmbmemberId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;

    @Override
    public String toString() {
        return "ViewAndUpdateMembersDTO{" +
                "cmbmemberId=" + cmbmemberId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public ViewAndUpdateMembersDTO() {
    }

    public ViewAndUpdateMembersDTO(String fullName, String email, String address, String phoneNumber, Integer cmbmemberId) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cmbmemberId = cmbmemberId;
    }

    public Integer getCmbmemberId() {
        return cmbmemberId;
    }

    public void setCmbmemberId(Integer cmbmemberId) {
        this.cmbmemberId = cmbmemberId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
