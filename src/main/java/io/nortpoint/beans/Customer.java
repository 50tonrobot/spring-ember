package io.nortpoint.beans;

public class Customer {

  private Integer id;

  private String fullName;

  private String phone;

  public Customer() {
  }

  public Customer(Integer id, String fullName, String phone) {
    this.id = id;
    this.fullName = fullName;
    this.phone = phone;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "Customer [id=" + id + ", fullName=" + fullName + ", phone=" + phone + "]";
  }

}
