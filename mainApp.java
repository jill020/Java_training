package com.bpi.oop;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		person myName = new person();
        myName.name = "Jillian";
        myName.name();
        
        System.out.println();
        
		house myHouse = new house();
        myHouse.address = "Binangonan, Rizal";
        myHouse.add1();
        
        System.out.println();
        
        tree myTree = new tree();
        myTree.nameTree = "Saging";
        myTree.nameT();
	}

}
