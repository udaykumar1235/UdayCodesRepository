package com.uday.springcloud;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uday.springcloud.Entities.Image;
import com.uday.springcloud.repository.ImageRepository;

@SpringBootTest
class ImagesFilesStoresDbProjectApplicationTests {

	@Autowired
	ImageRepository repo;
	
	@Test
	public void testImageSave() throws IOException {
		
		Image image = new Image();
		image.setId(1);
		image.setName("maven.png");
		
		
		File file = new File("/C://imagesfolder/maven.png");
		byte fileContent[] = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(fileContent);
		
		image.setData(fileContent);
		repo.save(image);
		inputStream.close();
	}
	
	@Test
	public void testReadImage() {
		
		Image image = repo.findById(1L).get();
		
		File file = new File("/C://ImageSavedFolder/" + image.getName());
		
	//	File file = new File("/C://Users//2336277//OneDrive - Cognizant//Documents//ImagesFolder/" + image.getName());
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(image.getData());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	
	}

}
