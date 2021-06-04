package com.digite.kata;

public class Car
{
    private String m_color;
    private String m_regNo;

    public Car(String a_color, String a_rego)
    {
        this.m_color = a_color;
        this.m_regNo = a_rego;
    }

    public String getColor() {
        return m_color;
    }

    public String getRegNo() {
        return m_regNo;
    }

}
