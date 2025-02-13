package com;

class ABC implements A{
	private static boolean check=false;
	@Override
	public void xyz() {
		// TODO Auto-generated method stub
		check=true;
	}
	public boolean getCheck() {
		return check;
	}
}
