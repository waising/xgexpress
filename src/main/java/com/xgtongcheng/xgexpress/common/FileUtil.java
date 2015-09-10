package com.xgtongcheng.xgexpress.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class FileUtil {
	/**
     * 将源文件的数据写入到目标文件中，
     * 不会检查源文件是否存在，
     * 若目标文件存在则直接写入，
     * 否则创建目标文件后再进行写入。
     * @param srcPath
     * @param desPath
     */
    private static void copyFile(String srcPath,String desPath){
        try {
            FileInputStream in = new FileInputStream(srcPath);
            FileOutputStream out = new FileOutputStream(desPath);
            byte[] bt = new byte[1024];
            int count;
            while ((count = in.read(bt)) > 0) {
                out.write(bt, 0, count);
            }
            in.close();
            out.close(); 
        } catch (IOException ex) {
            ex.printStackTrace();
        }    	
    }
    
    /**
     * 复制文件，若文件存在则替换该文件。
     * @param srcPath
     * @param desPath
     * @throws Exception
     */
    public static void copyAndReplaceFile(String srcPath,String desPath) throws Exception{
    	srcPath = separatorReplace(srcPath);
    	desPath = separatorReplace(desPath);
    	File srcFile = new File(srcPath);
    	if(!srcFile.isFile()){
    		throw new Exception("source file not found!");
    	}
    	copyFile(srcPath,desPath);
    }
    
    
    /**
     * 复制文件，若文件已存在则不进行替换。
     * @param srcPath
     * @param desPath
     * @throws Exception
     */
    public static void copyAndNotReplaceFile(String srcPath,String desPath) throws Exception{
    	srcPath = separatorReplace(srcPath);
    	desPath = separatorReplace(desPath);
    	File srcFile = new File(srcPath);
    	File desFile = new File(desPath);
    	if(!srcFile.isFile()){
    		throw new Exception("source file not found!");
    	}
    	if(desFile.isFile()){
    		return;
    	}
    	copyFile(srcPath,desPath);
    }
    
    /**
     * 移动文件，若文件存在则替换该文件。
     * @param srcPath
     * @param desPath
     * @throws Exception
     */
    public static void moveAndReplaceFile(String srcPath,String desPath) throws Exception{
    	srcPath = separatorReplace(srcPath);
    	desPath = separatorReplace(desPath);
    	copyAndReplaceFile(srcPath,desPath);
    	deleteFile(srcPath);
    }
    
    /**
     * 移动文件，若文件存在则不进行替换。
     * @param srcPath
     * @param desPath
     * @throws Exception
     */
    public static void moveAndNotReplaceFile(String srcPath,String desPath) throws Exception{
    	srcPath = separatorReplace(srcPath);
    	desPath = separatorReplace(desPath);
    	copyAndNotReplaceFile(srcPath,desPath);
    	deleteFile(srcPath);
    }
    
    /**
     * 复制并合并文件夹，
     * 不会替换目标文件夹中已经存在的文件或文件夹。
     * @param srcPath
     * @param desPath
     * @throws Exception 
     */
    public static void copyAndMergerFolder(String srcPath,String desPath) throws Exception{    	
    	srcPath = separatorReplace(srcPath);
    	desPath = separatorReplace(desPath);
    	File folder = getFolder(srcPath);
    	createFolder(desPath);
    	File[] files = folder.listFiles();
    	for(File file:files){
    		String src = file.getAbsolutePath();
    		String des = desPath+File.separator+file.getName();
    		if(file.isFile()){
    			copyAndNotReplaceFile(src,des);
    		}else if(file.isDirectory()){
    			copyAndMergerFolder(src,des);
    		}
    	}
    }
    
    /**
     * 复制并替换文件夹，
     * 将目标文件夹完全替换成源文件夹，
     * 目标文件夹原有的资料会丢失。
     * @param srcPath
     * @param desPath
     * @throws Exception 
     */
    public static void copyAndReplaceFolder(String srcPath,String desPath) throws Exception{   
    	srcPath = separatorReplace(srcPath);
    	desPath = separatorReplace(desPath);
    	File folder = getFolder(srcPath);
    	createNewFolder(desPath);
    	File[] files = folder.listFiles();
    	for(File file:files){
    		String src = file.getAbsolutePath();
    		String des = desPath+File.separator+file.getName();
    		if(file.isFile()){
    			copyAndReplaceFile(src,des);
    		}else if(file.isDirectory()){
    			copyAndReplaceFolder(src,des);
    		}
    	}
    } 
    
    /**
     * 合并文件夹后，将源文件夹删除。
     * @param srcPath
     * @param desPath
     * @throws Exception 
     */
    public static void moveAndMergerFolder(String srcPath,String desPath) throws Exception{
    	srcPath = separatorReplace(srcPath);
    	desPath = separatorReplace(desPath);    	
    	copyAndMergerFolder(srcPath,desPath);
    	deleteFolder(srcPath);
    }
    
    /**
     * 替换文件夹后，将源文件夹删除。
     * @param srcPath
     * @param desPath
     * @throws Exception 
     */
    public static void moveAndReplaceFolder(String srcPath,String desPath) throws Exception{
    	srcPath = separatorReplace(srcPath);
    	desPath = separatorReplace(desPath);
    	copyAndReplaceFolder(srcPath,desPath);
    	deleteFolder(srcPath);
    }    

    /**
     * 创建文件夹，如果文件夹存在则不进行创建。
     * @param path
     * @throws Exception 
     */
    public static void createFolder(String path) throws Exception{
    	path = separatorReplace(path);
    	File folder = new File(path);
    	if(folder.isDirectory()){
    		return;
    	}else if(folder.isFile()){
    		deleteFile(path);
    	}
    	folder.mkdirs();
    }
    
    /**
     * 创建一个新的文件夹，如果文件夹存在，则删除后再创建。
     * @param path
     * @throws Exception
     */
    public static void createNewFolder(String path) throws Exception{
    	path = separatorReplace(path);
    	File folder = new File(path);
    	if(folder.isDirectory()){
    		deleteFolder(path);
    	}else if(folder.isFile()){
    		deleteFile(path);
    	}
    	folder.mkdirs();
    }
    
    /**
     * 创建一个文件，如果文件存在则不进行创建。
     * @param path
     * @throws Exception
     */
    public static File createFile(String path) throws Exception{
    	path = separatorReplace(path);
    	File file = new File(path);
    	if(file.isFile()){
    		return file;
    	}else if(file.isDirectory()){
    		deleteFolder(path);
    	}
    	return createFile(file);
    }
    
    /**
     * 创建一个新文件，如果存在同名的文件或文件夹将会删除该文件或文件夹，
     * 如果父目录不存在则创建父目录。
     * @param path
     * @throws Exception
     */
    public static File createNewFile(String path) throws Exception{
    	path = separatorReplace(path);
    	File file = new File(path);
    	if(file.isFile()){
    		deleteFile(path);
    	}else if(file.isDirectory()){
    		deleteFolder(path);
    	}
    	return createFile(file);
    }
    
    /**
     * 分隔符替换
     * window下测试通过
     * @param path
     * @return
     */
    public static String separatorReplace(String path){
    	return path.replace("\\","/");
    }
    
    /**
     * 创建文件及其父目录。
     * @param file
     * @throws Exception
     */
    public static File createFile(File file) throws Exception{
    	createParentFolder(file);
    	if(!file.createNewFile()) {
    		throw new Exception("create file failure!");
    	}
    	return file;
    }
    
    /**
     * 创建父目录
     * @param file
     * @throws Exception
     */
    private static void createParentFolder(File file) throws Exception{
    	if(!file.getParentFile().exists()) {
    		if(!file.getParentFile().mkdirs()) {
    			throw new Exception("create parent directory failure!");
    		}
    	}
    }
    
    /**
     * 根据文件路径删除文件，如果路径指向的文件不存在或删除失败则抛出异常。
     * @param path
     * @return
     * @throws Exception 
     */
    public static void deleteFile(String path) throws Exception {
    	path = separatorReplace(path);
        File file = getFile(path);    
        if(!file.delete()){
        	throw new Exception("delete file failure");
        }                      
    }
    
    /**
     * 删除指定目录中指定前缀和后缀的文件。
     * @param dir
     * @param prefix
     * @param suffix
     * @throws Exception 
     */
    public static void deleteFile(String dir,String prefix,String suffix) throws Exception{     
    	dir = separatorReplace(dir);
    	File directory = getFolder(dir);
    	File[] files = directory.listFiles();
    	for(File file:files){
    		if(file.isFile()){
    			String fileName = file.getName();
    			if(fileName.startsWith(prefix)&&fileName.endsWith(suffix)){
    				deleteFile(file.getAbsolutePath());
    			}
    		}
    	}    
    }
    
    /**
     * 根据路径删除文件夹，如果路径指向的目录不存在则抛出异常，
     * 若存在则先遍历删除子项目后再删除文件夹本身。
     * @param path
     * @throws Exception 
     */
    public static void deleteFolder(String path) throws Exception {
    	path = separatorReplace(path);
        File folder = getFolder(path);
        File[] files = folder.listFiles(); 
        for(File file:files) {                
            if(file.isDirectory()){
            	deleteFolder(file.getAbsolutePath());
            }else if(file.isFile()){                	
            	deleteFile(file.getAbsolutePath());                                	
            }
        }  
        folder.delete(); 
    }
    
    /**
     * 查找目标文件夹下的目标文件
     * @param dir
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public static File searchFile(String dir,String fileName) throws FileNotFoundException{
    	dir = separatorReplace(dir);
    	File f = null;
        File folder = getFolder(dir);
        File[] files = folder.listFiles(); 
        for(File file:files) {                
            if(file.isDirectory()){
            	f =  searchFile(file.getAbsolutePath(),fileName);
            	if(f!=null){
            		break;
            	}
            }else if(file.isFile()){ 
            	if(file.getName().equals(fileName)){
            		f = file;
            		break;
            	}            			                                	
            }
        }          
    	return f;
    }
          
    /**
     * 获得文件类型。
     * @param path：文件路径
     * @return
     * @throws FileNotFoundException 
     */
	public static String getFileType(String path) throws FileNotFoundException {
		path = separatorReplace(path);
		File file = getFile(path);
		String fileName = file.getName();
		String[] strs = fileName.split("\\.");
		if(strs.length<2){
			return "unknownType";
		}
		return strs[strs.length-1];
	}
	
	/**
	 * 根据文件路径，获得该路径指向的文件的大小。
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	public static long getFileSize(String path) throws FileNotFoundException{
		path = separatorReplace(path);		
		File file = getFile(path);
		return file.length();
	}
	
	/**
	 * 根据文件夹路径，获得该路径指向的文件夹的大小。
	 * 遍历该文件夹及其子目录的文件，将这些文件的大小进行累加，得出的就是文件夹的大小。
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	public static long getFolderSize(String path) throws FileNotFoundException{
		path = separatorReplace(path);				
		long size = 0;
		File folder = getFolder(path);
		File[] files = folder.listFiles();
		for(File file:files){
			if(file.isDirectory()){
				size += getFolderSize(file.getAbsolutePath());
			}else if(file.isFile()){
				size += file.length();
			}
		}
		return size;
	}
	
	/**
	 * 通过路径获得文件，
	 * 若不存在则抛异常，
	 * 若存在则返回该文件。
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	public static File getFile(String path) throws FileNotFoundException{
		path = separatorReplace(path);				
		File file = new File(path);
		if(!file.isFile()){
			throw new FileNotFoundException(getFileName(path)+"file not found!");
		}
		return file;
	}
	
	/**
	 * 通过路径获得文件夹，
	 * 若不存在则抛异常，
	 * 若存在则返回该文件夹。
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	public static File getFolder(String path) throws FileNotFoundException{
		path = separatorReplace(path);				
		File folder = new File(path);
		if(!folder.isDirectory()){
			throw new FileNotFoundException("folder not found!");
		}
		return folder;
	}
	
	/**
	 * 获得文件最后更改时间。
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Date getFileLastModified(String path) throws FileNotFoundException{
		path = separatorReplace(path);				
		File file = getFile(path);
		return new Date(file.lastModified());
	}
	
	/**
	 * 获得文件夹最后更改时间。
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Date getFolderLastModified(String path) throws FileNotFoundException{
		path = separatorReplace(path);		
		File folder = getFolder(path);
		return new Date(folder.lastModified());
	}
	
	  /**
     * 获取文件扩展名
     * @param file
     * @return
     */
    public static String getTypePart(String fileName) {
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
    
    /**
     * 获取文件名
     * @author : wwx
     * @Description : TODO
     * @CreateDate : 2014年8月5日
     * @param filePath
     * @return
     */
    public static String getFileName(String filePath){
    	String fileName = "";
    	String temp[] = filePath.replaceAll("////","/").split("/");
    	if (temp.length > 1) {
    		fileName = temp[temp.length - 1];
    	}
    	return fileName;
    }
    
    /**}
     * 重命名文件或文件夹
     * @author : wwx
     * @Description : TODO
     * @CreateDate : 2014年8月5日
     * @param resFilePath
     * @param newFileName
     * @return
     */
    public static boolean renameFile(String resFilePath, String newFileName) {  
        String newFilePath = getFileFolderPath(resFilePath) + "\\" + newFileName;  
        File resFile = new File(resFilePath);  
        File newFile = new File(newFilePath);  
        return resFile.renameTo(newFile);  
    }
    
    /**
     * 文件是否存在
     * @author : wwx
     * @Description : TODO
     * @CreateDate : 2014年8月5日
     * @param filePath
     * @return
     */
    public static boolean isExist(String filePath) {  
        return new File(filePath).exists();  
    } 
    
    /**
     * 文件所在目录
     * @author : wwx
     * @Description : TODO
     * @CreateDate : 2014年8月5日
     * @param path
     * @return
     */
    public static String getFileFolderPath(String path){
    	return new File(path).getParent();
    }
}
