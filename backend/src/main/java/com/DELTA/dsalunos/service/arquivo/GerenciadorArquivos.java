package com.DELTA.dsalunos.service.arquivo;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.xml.bind.DatatypeConverter;
import javax.imageio.ImageIO;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class GerenciadorArquivos implements IGerenciadorArquivos {
	
	private ServletContext context;
	
	private final String extensionFileImages;
	
	public GerenciadorArquivos(ServletContext context, Environment env) {
		this.context = context;
		extensionFileImages = env.getProperty("extensionFileImages");
	}
	
	public String criarArquivo(String base64) {
		UUID nameFile = UUID.randomUUID();
		OutputStream outputStream = null;
		try {
			boolean directoryCreated = true;
			byte[] imageByte = DatatypeConverter.parseBase64Binary(base64);
			String pathFile = context.getRealPath("") + "resources\\static\\";
			File directory = new File(pathFile);
			if (!directory.exists()){
				directoryCreated = directory.mkdir();
			}
			if(directoryCreated) {
				String fileName = pathFile + nameFile.toString() + "." + extensionFileImages;
				File file = new File(fileName);
				file.createNewFile();
				outputStream = new BufferedOutputStream(new FileOutputStream(file));
				outputStream.write(imageByte);
				outputStream.close();
				return fileName;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String recuperarArquivo(String nome) {
		BufferedImage img = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			img = ImageIO.read(new File(nome));
			ImageIO.write(img, extensionFileImages, bos);
			return Base64.getEncoder().encodeToString(bos.toByteArray());
		}
		catch(IOException e) {
			e.printStackTrace();
			return "";
		}
		
	}
	
	public boolean deletarArquivo(String nome) {
		File imgToDelete = new File(nome);
		return imgToDelete.delete();
	}
	
}
