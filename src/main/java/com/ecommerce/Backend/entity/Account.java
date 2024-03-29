package com.ecommerce.Backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long account_id;

  @Column(name = "email")
  private String email;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  // constructors
  public Account() {
  }

  public Account(long account_id, String email, String username, String password) {
    this.account_id = account_id;
    this.email = email;
    this.username = username;
    this.password = password;
  }

  // getters and setters
  public long getaccount_id() {
    return account_id;
  }

  public void setAccoundId(long account_id) {
    this.account_id = account_id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  // need to create override methods
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Account other = (Account) obj;

    if (account_id == null) {
      if (other.account_id != null)
        return false;
    } else if (!account_id.equals(other.account_id))
      return false;

    if (email == null) {
      if (other.email == null)
        return false;
    } else if (!email.equals(other.email))
      return false;

    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;

    if (username == null) {
      if (other.username != null)
        return false;
    } else if (!username.equals(other.username))
      return false;

    return true;
  }

  @Override
  public String toString() {
    return "Account{" + "accountId='" + account_id + '\'' +
        ", name'" + username + '\'' +
        ", email'" + email + '\'' +
        ", username'" + username + '\'' +
        ", password'" + password + '\'' +
        '}';
  }
}
