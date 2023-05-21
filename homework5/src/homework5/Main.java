package homework5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		try {
			System.out.println("Ödeme Tutarı griniz");
			String totalAmount=scanner.nextLine();
			if(!isValidAmount(totalAmount)) {
				 throw new TotalAmountException("Tutar geçersiz.Tam tutar olmalı ve harf içeremez.");
		}
			System.out.println("Kart numarası giriniz");
			String cardNo=scanner.nextLine();
			if(!isValidCardNo(cardNo)) {
				throw new CardHolderException("Geçersiz Card No ");
			}
			
			 System.out.println("Son Kullanma Tarihi (MM/YY): ");
		        String expiryDate = scanner.nextLine();
		        validateExpiryDate(expiryDate);
			
		        System.out.println("Güvenlik Kodu: ");
		        int securityCode = scanner.nextInt();
		        validateSecurityCode(securityCode);
		        
		        pay();
			
		}catch (TotalAmountException | CardHolderException | IllegalArgumentException | SystemNotWorkingException  e){
			 System.out.println("Ödeme işlemi sırasında bir hata oluştu: " + e.getMessage());
	            System.out.println("İşlemi tekrar deneyin.");
			System.out.println( e.getMessage());
		}
	}

	private static void pay() throws SystemNotWorkingException {
		// TODO Auto-generated method stub
		System.out.println("Başarılı bir şekilde Ödeme yapılıyor");
		
		int random = (int) (Math.random() * 100);
		 System.out.println("Sistem kontrol ediliyor...");
		 
		 if(random >75) {
			 throw new SystemNotWorkingException("Sistem şu anda çalışmıyor. Lütfen daha sonra tekrar deneyin.");
		 }
		 System.out.println("Ödeme tamamlandı.");
	}

	private static void validateSecurityCode(int securityCode) {
		// TODO Auto-generated method stub
		String securityCodeStr = String.valueOf(securityCode);
        if (securityCodeStr.length() != 3 || !securityCodeStr.matches("\\d{3}")) {
            throw new IllegalArgumentException("Geçersiz güvenlik kodu.");
        }
	}

	private static void validateExpiryDate(String expiryDate) {
		// TODO Auto-generated method stub
		String[] parts= expiryDate.split("/");
		 if (parts.length != 2 || parts[0].length() != 2 || parts[1].length() != 2) {
	            throw new IllegalArgumentException("Geçersiz son kullanma tarihi formatı.");
	        }
		
		int month = Integer.parseInt(parts[0]);
		int year = Integer.parseInt(parts[1]);
		if(month <  1 || month >12 || year <22) {
			throw new IllegalArgumentException("Geçersiz son kullanma tarihi.");
		}
	}



	private static boolean isValidCardNo(String cardNo) {
		// TODO Auto-generated method stub
		if(cardNo.length() !=16) {
			return false;
		}
		for(char c: cardNo.toCharArray()) {
			if(!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}



	private static boolean isValidAmount(String totalAmount) {
		// TODO Auto-generated method stub

	    for (char c : totalAmount.toCharArray()) {
	      if (!Character.isDigit(c)) {
	        return false;
	      }
	     
	    }
		return true;
	}



}
