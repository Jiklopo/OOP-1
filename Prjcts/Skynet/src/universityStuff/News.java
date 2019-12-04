/*Class News is used to create and show news related to the university*/

package universityStuff;

import java.io.*;
import java.util.*;
import universityStuff.*;

public class News implements Serializable {

	private String header;

    
    private String preview;

    
    private String text;

    
    public static Vector<News> createdNews;

    
    private Date date;

    public News(String header, String preview, String text, Date date) {
    	this.header=header;
    	this.preview=preview;
    	this.text=text;
    	this.date=date;
    }
    
    public News() {
    	super();
    }
    
    
    public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}


	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}


	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}


	public static boolean deleteNews(News news) {
        return false;
    }
	
	
    
    public static boolean createNews(News news) {
        return false;
    }

        public static void serialize(String path) throws IOException {
        	          
                FileOutputStream file = new FileOutputStream(path + "news.out"); 
                ObjectOutputStream out = new ObjectOutputStream(file); 
                  
                out.writeObject(createdNews); 
                out.flush();
                out.close();       
            } 
                  
    public static void deserialize(String path) throws IOException, ClassNotFoundException {
    	   
             FileInputStream file = new FileInputStream(path + "news.out"); 
             ObjectInputStream in = new ObjectInputStream(file); 
               
             createdNews = (Vector<News>)in.readObject(); 
             in.close(); 
             file.close(); 
         }

	@Override
	public String toString() {
		return "News [header=" + header + ", preview=" + preview + ", text=" + text + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		result = prime * result + ((preview == null) ? 0 : preview.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
	    if (o == this) return true;
	    if(!(o instanceof News)) return false;
	    News n = (News) o;
	    return (this.header.equals(n.header) && this.preview.equals(n.preview) && this.text.equals(n.text) && this.date.equals(n.date));
	}
           
        
}



