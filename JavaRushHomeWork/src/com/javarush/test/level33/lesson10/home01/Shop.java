package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 14.09.2016.
 */
@XmlType(name = "shop")
@XmlRootElement
public class Shop
{
    @XmlElementWrapper(name = "goods",nillable = true)
    public List<String> names;
    @XmlElement(name = "count")
    int count;
    @XmlElement(name = "profit")
    double profit;

    @XmlElement(name = "secretData")
    public List<String> secretData;

    public Shop()
    {
        names = new ArrayList<>();
        secretData = new ArrayList<>();
    }
}
