package com.yzm.pojo;

import java.io.Serializable;

/**
 * description:
 *
 * @author yzm
 * @date 2024/5/13
 */
public class User implements Serializable {

  private long id;
  private String username;
  private String password;
  private String email;
  private int age;
  private String sex;
  private String tel;
  private String addr;
  private String card;
  private boolean married;
  private float salary;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public String getCard() {
    return card;
  }

  public void setCard(String card) {
    this.card = card;
  }

  public boolean getMarried() {
    return married;
  }

  public void setMarried(boolean married) {
    this.married = married;
  }

  public float getSalary() {
    return salary;
  }

  public void setSalary(float salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", email='" + email + '\'' +
      ", age=" + age +
      ", sex='" + sex + '\'' +
      ", tel='" + tel + '\'' +
      ", addr='" + addr + '\'' +
      ", card='" + card + '\'' +
      ", married=" + married +
      ", salary=" + salary +
      '}';
  }
}
