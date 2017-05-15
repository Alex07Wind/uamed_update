package de.vogella.mysql.first.test;

public class ColorImage {


		public String shortcolorname;
		public String fullcolorname;
		public String filename;
		public String filenamesite;
		public String linkimage;
		public float price;
		public float priceuah;

		public ColorImage() {
		}
		public void SetShortColorName( String newname) {
			shortcolorname = newname.toUpperCase();
		}	
		public void SetFullColorName( String newname) {
			fullcolorname = newname.toUpperCase();
		}	
		public void SetFileName( String newfname) {
			filename = newfname;
		}
		public void SetFileNameSite( String newfnamesite) {
			filenamesite = newfnamesite;
		}
		public void SetPrice( float newprice) {
			price = newprice;
		}
		public void SetPriceUAH( float newpriceuah) {
			priceuah = newpriceuah;
		}
		public void SetLinkImage( String newlink) {
			linkimage = newlink;
		}
		public String GetShortColorName() {
			return shortcolorname;
		}
		public String GetFullColorName() {
			return fullcolorname;
		}

		public String GetFileName() {
			return filename;
		}
		public String GetFileNameSite() {
			return filenamesite;
		}
		public float GetPrice() {
			return price;
		}
		public float GetPriceUAH() {
			return priceuah;
		}
		public String GetLinkImage() {
			return linkimage;
		}

		
	
}
