
package algoritmasorusu;
 
   
     
public class AlgoritmaSorusu {
     public long telefon_no;
    public int Musteri_numarasi;
        public int Musteri_kimlik_no;
        public String Kullanici_adi;
        public double para_miktari;
        public String islem_tarihi;
        public int fatura_no;
        public double havale_miktari;
        public double fatura_miktari;
        public double yatirilan_para;
        public double cekilen_para;
        public String Sifre;
        private boolean odeme;
        
        AlgoritmaSorusu(){
            this.Kullanici_adi="Halid DERVİŞ";
            this.Musteri_kimlik_no=12345678;
            this.Musteri_numarasi=6656544;
       }
        
        public void yeni_musteri(int uye_no,int kimlik_no,String uye_adi)
        {
           Musteri_numarasi=uye_no;
           Musteri_kimlik_no=kimlik_no;
           Kullanici_adi=uye_adi;        
        }
         
        public  double para_yatirma(double yatirilan_para)
        {
         this.yatirilan_para=yatirilan_para;
            para_miktari = para_miktari+yatirilan_para;
            return para_miktari;
        }
        public double para_cekme(double cekilen_para)
        {
            if(cekilen_para<=para_miktari)
            {
             para_miktari=para_miktari-cekilen_para;   
            }
            else
            {
                System.out.println("Hesabta yeterli bakiyeniz bulunmamaktadir");
            }
            return para_miktari;
        }
        private boolean fatura_odemesi(int fatura_no,double fatura_miktari)
        {
            if(fatura_miktari<=para_miktari)
            {
                para_miktari=para_miktari-fatura_miktari;
                return true;
            }
            else
                return false;
        }
        
        public String Havale(double havale_miktari)
        {
         String mesaj="";
         if(para_miktari<havale_miktari)
         {
           mesaj=" yeterli bakieniz olmadigi icin Havale islemi tamamlanmadi "; 
         }
         else
         {
           para_miktari=para_miktari-havale_miktari; 
           mesaj="Havele "+havale_miktari+ "  TL islemi basariyla gerceklestirimistir";
         }
         return  mesaj;
        }
        
        public String Havale(double havale_miktari,String islem_tarih)
        {
         
         String mesaj="";
         if(para_miktari<havale_miktari)
         {
           mesaj=" yeterli bakieniz olmadigi icin Havale islemi tamamlanmadi "+islem_tarih; 
         }
         else
         {
           para_miktari=para_miktari-havale_miktari; 
           mesaj="islem basariyla gerceklestirimistir "+islem_tarih;
         }
         return  mesaj;
        }

    public static void main(String[] args) {
       
      ozel_islemler o=new ozel_islemler();
      
      o.Sifre="FiratElazig";
      o.cekilen_para=2900;
      o.fatura_miktari=1900.9;
      o.havale_miktari=123;
      o.para_miktari=654564;
      o.telefon_no=745435345;
      o.yatirilan_para=23345;
      o.iban_no="35324322433435";
      o.islem_tarihi="01.06.2020";
      o.Goster();
     
    }
    
    
}
class ozel_islemler extends AlgoritmaSorusu
     {
        public String iban_no;
       
        
         
         public String sifre_yazma(String sifre)
         {
             boolean kontrol=true;
             this.Sifre=sifre;
            if(sifre.length()>5)
            {
                for (int i = 0; i <sifre.length()-1; i++) {
                   if(sifre.charAt(i)==sifre.charAt(i+1))
                   {
                       kontrol=false;
                       break;
                   }
                }
                
  
            }
            else
            {
                 kontrol=false;
            }
            
            if(kontrol)
               Sifre="Sifre degistirildi Sifreniz:"+sifre;
            else 
               Sifre="yazilan sifre karkater sayisi en 9 yan yana benzer olamayan karakterden olusmali";
            
            return Sifre;
         }
         
         public String Cep_TL_Yukle(long telefon_No)
         {
             String mesaj="";
          this.telefon_no=telefon_No;
          if(para_miktari>30)
          {
             mesaj=telefon_No+" Telefon numarasina 2GB yuklendi"; 
          }
          else
          {
              mesaj="Bakiyenuz yetersiz";
          }
          return mesaj;
         }
         
         private  String mukkemel_IBAN(String iben)
         {
             String sonuc="";
             double iben_no=Double.parseDouble(iben);
             int basamak=0;
             double toplam=0;
             while(iben_no>0)
             {
                toplam=toplam+iben_no%10;
                iben_no=iben_no/10;
                basamak++;              
             }
             if(toplam%basamak==0)
                 sonuc=iben+" MUKKEMEL IBEN";
             else
                 sonuc=iben+" MUKKEMEL IBEN";
           return sonuc; 
         }
         
         public int Dogrulama_kodu(){
             
             
          int kimlik_basmak_top=0;  
          while(Musteri_kimlik_no > 0){
              kimlik_basmak_top=kimlik_basmak_top+Musteri_kimlik_no%10;
              Musteri_kimlik_no=Musteri_kimlik_no/10;
          }
          int asal_sayi=2;
          int sonuc=-1;
          while(kimlik_basmak_top>0)
          {
            boolean kontrol=true;
            for(int i=2;i<asal_sayi;i++)
            {
               if(asal_sayi%i==0)
               {
                 kontrol=false;
                 break;
                }
            }
            if(kontrol)
            {
              sonuc=asal_sayi;
              kimlik_basmak_top=kimlik_basmak_top-1;
            }
             asal_sayi++;
         
        }
        return sonuc;
     }
         
         
         
         void Goster()
         {
             System.out.println((Musteri_numarasi+" "+Musteri_kimlik_no+" "+Kullanici_adi));
             System.out.println(para_yatirma(yatirilan_para));
             System.out.println(para_cekme(cekilen_para));
             System.out.println(Havale(havale_miktari));
             System.out.println(sifre_yazma(Sifre));
             System.out.println(Cep_TL_Yukle(telefon_no));
             System.out.println(mukkemel_IBAN(iban_no));
             System.out.println(Havale(havale_miktari,islem_tarihi));
             System.out.println(Dogrulama_kodu());
             
         }
         
          
     }
