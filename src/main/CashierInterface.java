package main;

import java.util.ArrayList;

public interface CashierInterface {

	public int calculateTotal(ArrayList<Integer> subTotal);
	
	public void summaryMakanan(String namaMakanan, int hargaMakanan);
	public void summaryMakanan(String namaMakanan, String namaMinuman, int hargaMakanan);
	
	public void receiptPembayaran(ArrayList<String> namaMakanan, ArrayList<Integer> harga);
	public void receiptPembayaran(ArrayList<String> namaMakanan, ArrayList<String> namaMinuman, ArrayList<Integer> harga);
}
