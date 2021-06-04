package com.digite.kata.tracker;

public class Car
{
    private String m_color;
    private String m_regNo;
    private String m_ownerName;

    public Car(String a_color, String a_rego, String a_ownerName)
    {
        this.m_color = a_color;
        this.m_regNo = a_rego;
        this.m_ownerName = a_ownerName;
    }

    public String getColor() {
        return m_color;
    }

    public String getRegNo() {
        return m_regNo;
    }
    
    public String getOwnerName() {
    	return m_ownerName;
    }

}