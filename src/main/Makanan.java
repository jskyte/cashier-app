package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Makanan implements CashierInterface{
	
	String namaMakanan;
	int hargaMakanan;


	public Makanan() {
		super();
	}

	public Makanan(String namaMakanan, int hargaMakanan) {
		super();
		this.namaMakanan = namaMakanan;
		this.hargaMakanan = hargaMakanan;
	}
	
	@Override
	public void summaryMakanan(String namaMakanan, int hargaMakanan) {
		System.out.println("Item: " + namaMakanan + ", Harga: Rp. " + hargaMakanan);
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
	public void receiptPembayaran(ArrayList<String> namaMakanan, ArrayList<Integer> harga) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String formattedDate = date.format(formatter);
		System.out.println();
		System.out.println();
		System.out.println("Tanggal: " + formattedDate);
		System.out.println("============== Summary ==============");
		for (int i = 0; i < namaMakanan.size(); i++) {
			summaryMakanan(namaMakanan.get(i), harga.get(i));
		}
		System.out.println("-------------------------------------");
		System.out.println("Subtotal Harga Makanan: Rp. " + calculateTotal(harga));
		System.out.println("Ppn 10%: Rp. " + 0.1 * calculateTotal(harga));
		System.out.println("Total Harga: Rp. " + (0.1 * calculateTotal(harga) + calculateTotal(harga)));
		System.out.println("=====================================");
		
	}

	@Override
	public void receiptPembayaran(ArrayList<String> namaMakanan, ArrayList<String> namaMinuman,
			ArrayList<Integer> harga) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void summaryMakanan(String namaMakanan, String namaMinuman, int hargaMakanan) {
		// TODO Auto-generated method stub
		
	}

}
