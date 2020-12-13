package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PaketMakanan implements CashierInterface {
	String makananString, minumanString;
	int num, harga;
	
	
	public PaketMakanan() {
		super();
	}

	public PaketMakanan(int num, String makananString, String minumanString, int harga) {
		super();
		this.makananString = makananString;
		this.minumanString = minumanString;
		this.num = num;
		this.harga = harga;
	}
	
	public String getMakananString() {
		return makananString;
	}

	public void setMakananString(String makananString) {
		this.makananString = makananString;
	}

	public String getMinumanString() {
		return minumanString;
	}

	public void setMinumanString(String minumanString) {
		this.minumanString = minumanString;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

	@Override
	public String toString() {
		return this.num + ". " + this.makananString + ", " + this.minumanString + ", Rp. " + harga;
	}

	@Override
	public int calculateTotal(ArrayList<Integer> subTotal) {
		// TODO Auto-generated method stub	
		int sum = 0;
		for (int i = 0; i < subTotal.size(); i++) {
			sum += subTotal.get(i);
		}	
		return sum;
	}
	
	@Override
	public void summaryMakanan(String namaMakanan, String namaMinuman, int hargaMakanan) {
		// TODO Auto-generated method stub
		System.out.println("Makanan: " + namaMakanan + ", Minuman: " + namaMinuman + ", Harga: Rp. " + hargaMakanan);
	}
	
	@Override
	public void receiptPembayaran(ArrayList<String> namaMakanan, ArrayList<String> namaMinuman, ArrayList<Integer> harga) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String formattedDate = date.format(formatter);
		System.out.println();
		System.out.println();
		System.out.println("Tanggal: " + formattedDate);
		System.out.println("============== Summary ==============");
		for (int i = 0; i < namaMakanan.size(); i++) {
			summaryMakanan(namaMakanan.get(i), namaMinuman.get(i), harga.get(i));
		}
		System.out.println("-------------------------------------");
		System.out.println("Subtotal Harga Makanan: Rp. " + calculateTotal(harga));
		System.out.println("Ppn 10%: Rp. " + 0.1 * calculateTotal(harga));
		System.out.println("Total Harga: Rp. " + (0.1 * calculateTotal(harga) + calculateTotal(harga)));
		System.out.println("=====================================");
	}

	@Override
	public void summaryMakanan(String namaMakanan, int hargaMakanan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiptPembayaran(ArrayList<String> namaMakanan, ArrayList<Integer> harga) {
		// TODO Auto-generated method stub
		
	}

	
		
	
	
	
}
