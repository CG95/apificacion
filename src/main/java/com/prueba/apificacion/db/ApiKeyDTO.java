package com.prueba.apificacion.db;

import javax.persistence.*;

@Entity
public class ApiKeyDTO {
    @Id
    @SequenceGenerator(name = "app_user_sequence",
            sequenceName = "app_user_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "app_user_sequence")
    private Long id;
    private String hashType;
    private String password;
    private String apiName;


    public ApiKeyDTO() {
    }

    public ApiKeyDTO(Long id, String hashType, String password, String apiName) {
        this.id = id;
        this.hashType = hashType;
        this.password = password;
        this.apiName = apiName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHashType() {
        return hashType;
    }

    public void setHashType(String hashType) {
        this.hashType = hashType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    @Override
    public String toString() {
        return "ApiKeyDTO{" +
                "id=" + id +
                ", hashType='" + hashType + '\'' +
                ", password='" + password + '\'' +
                ", apiName='" + apiName + '\'' +
                '}';
    }
}
