package neteasesongdiff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class NeteaseCrawler {
	public static void main(String[] args){
		BufferedReader reader = null;
		String result = "";
		try{
			URL realUrl = new URL("http://music.163.com/#/playlist?id=6623638");
			URLConnection connection = realUrl.openConnection();
			connection.setRequestProperty("Accept", "*/*");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:53.0) Gecko/20100101 Firefox/53.0");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
			//connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			connection.setRequestProperty("Cookie", "_ntes_nnid=0f44c959256c4f826a196699b4d9c9b0,1493197443344; _ntes_nuid=0f44c959256c4f826a196699b4d9c9b0; _ga=GA1.2.1450890470.1454324236; __utma=94650624.1450890470.1454324236.1494918245.1496504895.3; vjuids=-4aa502d60.15ba980d101.0.a3196b47253848; vjlast=1493197443.1493197443.30; vinfo_n_f_l_n3=f88b75acc99b7b37.1.0.1493197443368.0.1493197508454; usertrack=c+5+hlkK7eJ6jwsKBjA2Ag==; JSESSIONID-WYYY=EP3NvI3atU%5Cz0vCiM%5CyPlnZ3GSplJqgHzVZjFCXP%2Bs18rcf7xSr%5C6hKjm3H2qHRSGHzgpaf5t1CGs6lFM7uuv44s4jCySQrfNz6CBJQ%2BsOSQBcmso8u%5CUMPPfEa7j%2FlUWQ8iNxK9wXxwk5gieU%5CRD8jzVdS44UxVT75Z7JWqWQJ%2BTg6T%3A1496508434302; _iuqxldmzr_=32; __utmz=94650624.1494918245.2.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmb=94650624.17.10.1496504895; __utmc=94650624; _ngd_tid=98r7KSRbFrDPWm%2FFBgxNtZj5VjrwQ%2BUc; __csrf=1e72e7c7f86ab15240afdafd03924e7a");
			
			// 发送POST请求必须设置如下两行
			connection.setDoOutput(true);
			connection.setDoInput(true);
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while((line = reader.readLine()) != null){
				result += line;
			}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
                if(reader != null){
                    reader.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
		}
		System.out.println(result);
	}
}
