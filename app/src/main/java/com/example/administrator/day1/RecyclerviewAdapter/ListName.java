package com.example.administrator.day1.RecyclerviewAdapter;

public class ListName {
    String lname,price;

    public String getLname() {
        return lname;
    }

    public int getImageid() {
        return Imageid;
    }

    int Imageid;



    public ListName(int Imageid, String lname, String price) {
        this.lname = lname;
        this.Imageid = Imageid;
        this.price = price;
    }

    public String getPrice() { return price; }
}
