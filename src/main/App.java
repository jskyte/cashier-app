package main;

import java.util.ArrayList;
import java.util.Scanner;



public class App {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		Makanan makanan = new Makanan();
		PaketMakanan paketMakanan = new PaketMakanan();
		ArrayList<PaketMakanan> listPaketMakanans = new ArrayList<PaketMakanan>();
		listPaketMakanans.add(new PaketMakanan(1, "Ayam + Nasi", "Sprite", 20000));
		listPaketMakanans.add(new PaketMakanan(2, "Tempe + Nasi", "Aqua", 11000));
		listPaketMakanans.add(new PaketMakanan(3, "Ikan + Nasi", "Fanta", 15000));
		
		int pilihMenu;
		char decUser;
		
		
		do {

			System.out.println("======= PROGRAM KASIR =======");

			System.out.println("-- Main Menu --");
			System.out.println("1. Paket Makanan");
			System.out.println("2. Ala Carte");
			System.out.println("3. Exit");
			System.out.print("Pilih Menu: ");
			pilihMenu = myScanner.nextInt();
			System.out.println("=============================");
			switch (pilihMenu) {
			case 1:
				
				ArrayList<String> paketMakananList = new ArrayList<>();
				ArrayList<String> minumanList = new ArrayList<>();
				ArrayList<Integer> hargaList = new ArrayList<>();
				
				for(PaketMakanan mknMakanan : listPaketMakanans) {
					System.out.println(mknMakanan);
				}
				
				System.out.print("Paket yang ingin dipilih: ");
				int pilihPaket = myScanner.nextInt() - 1;
				
				paketMakananList.add(listPaketMakanans.get(pilihPaket).getMakananString());
				minumanList.add(listPaketMakanans.get(pilihPaket).getMinumanString());
				hargaList.add(listPaketMakanans.get(pilihPaket).getHarga());
				
				System.out.println();
				System.out.println("============== Summary ==============");
				for (int i = 0; i < paketMakananList.size(); i++) {
					System.out.println("Makanan: " + paketMakananList.get(i) + ", Minuman: " + minumanList.get(i) + ", Harga: Rp. " + hargaList.get(i));
				}
				System.out.println("==================================");
				
				int counter = 1;
				while(counter == 1) {
					
					System.out.print("Apakah Customer ingin menambah paket? (y/n): ");
					decUser = myScanner.next().charAt(0);
					
					switch (decUser) {
					case 'Y':
					case 'y':
						
						
						for(PaketMakanan mknMakanan : listPaketMakanans) {
							System.out.println(mknMakanan);
						}
						
						System.out.println();
						System.out.print("Paket yang ingin dipilih: ");
						int paketTambahan = myScanner.nextInt() - 1;
						
						paketMakananList.add(listPaketMakanans.get(paketTambahan).getMakananString());
						minumanList.add(listPaketMakanans.get(paketTambahan).getMinumanString());
						hargaList.add(listPaketMakanans.get(paketTambahan).getHarga());
						
						System.out.println();
						System.out.println("===================== Summary =====================");
						for (int i = 0; i < paketMakananList.size(); i++) {
							System.out.println("Makanan: " + paketMakananList.get(i) + ", Minuman: " + minumanList.get(i) + ", Harga: Rp. " + hargaList.get(i));
						}
						System.out.println("================================================");
						break;
					
					case 'N':
					case 'n':
						paketMakanan.receiptPembayaran(paketMakananList, minumanList, hargaList);
						System.out.println();
						counter = 2;
						break;
					}
					
				}
				
				break;
				
			case 2:

				ArrayList<String> namaMakanan = new ArrayList<>();
				ArrayList<Integer> harga = new ArrayList<>();
				
				System.out.println();
				System.out.print("Jumlah item yang akan dimasukkan: ");
				int jumItem = myScanner.nextInt();
				System.out.println();

				for (int i = 0; i < jumItem; i++) {
					System.out.println("======= Tambah Item Restoran =======");
					System.out.print("Nama Item: ");
					String namaItemString = myScanner.next();
					namaMakanan.add(namaItemString);

					System.out.print("Harga Item: ");
					int hargaItem = myScanner.nextInt();
					harga.add(hargaItem);
				}
				
				System.out.println();
				System.out.println("============== Summary ==============");

				for (int i = 0; i < namaMakanan.size(); i++) {
					makanan.summaryMakanan(namaMakanan.get(i), harga.get(i));
				}

				System.out.println("==================================");
				System.out.println();
				
				int count = 1;
				while(count == 1) {
					System.out.println("Apakah Customer ingin menambah pesanan? (y/n)");
					decUser = myScanner.next().charAt(0);
						switch (decUser) {
						case 'Y':
						case 'y': 
								System.out.println("Berapa banyak item yang ingin ditambah? ");
								int itemTambahan = myScanner.nextInt();
		
								for (int i = 0; i < itemTambahan; i++) {
									System.out.print("Nama Item: ");
									String namaItemString = myScanner.next();
									namaMakanan.add(namaItemString);
		
									System.out.print("Harga Item: ");
									int hargaItem = myScanner.nextInt();
									harga.add(hargaItem);
								}
		
								System.out.println("============== Summary ==============");
								for (int i = 0; i < namaMakanan.size(); i++) {
									makanan.summaryMakanan(namaMakanan.get(i), harga.get(i));
								}
								System.out.println("==================================");
								System.out.println("Subtotal Harga Makanan: Rp. " + makanan.calculateTotal(harga));
								
								break;
						case 'N':
						case 'n': 
							makanan.receiptPembayaran(namaMakanan, harga);
							System.out.println();
							count = 2;
							break;
						}
						
				} 
				break;
				
			case 3:
				System.out.println("Terima kasih telah menggunakan aplikasi Kasir.");
				System.exit(0);
				break;

			default:
				System.out.println("Nomor yang Anda pilih salah.");
				System.out.println();
				break;
			}
		} while (pilihMenu != 3);
		myScanner.close();
		
	}
}
