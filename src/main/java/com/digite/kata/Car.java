package com.digite.kata;

public class Car
{
    private String m_color;
    private String m_regNo;
    private String m_owner;


    public Car(String a_color, String a_rego, String a_owner)
    {
        this.m_color = a_color;
        this.m_regNo = a_rego;
        this.m_owner = a_owner;
    }

    public String getColor() {
        return m_color;
    }

    public String getRegNo() {
        return m_regNo;
    }

    public String getOwner()
    {
        return  m_owner;
    }

}
