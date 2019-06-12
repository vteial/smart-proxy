package com.ahaitech.smartproxy.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SessionDto implements Serializable {

    long id;

    String userId;

    String emailId;

    String firstName;

    String lastName;

    String roleId;

    long branchId;

}
