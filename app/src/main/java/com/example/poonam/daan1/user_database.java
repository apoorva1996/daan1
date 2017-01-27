package com.example.poonam.daan1;

import static android.content.Intent.getIntent;

/**
 * Created by Poonam on 27-01-2017.
 */
public class user_database {
    String name,aadhar,address,password;
    String email;

    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    { return this.name;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public String getEmail()
    { return this.email;
    }
    public void setAadhar(String aadhar)
    {
        this.aadhar=aadhar;
    }
    public String getAadhar()
    { return this.aadhar;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
    public String getAddress()
    { return this.address;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public String getPassword()
    { return this.password;
    }
}
