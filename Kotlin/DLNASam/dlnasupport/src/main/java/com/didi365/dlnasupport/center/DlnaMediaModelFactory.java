package com.didi365.dlnasupport.center;

import android.content.Intent;
import android.text.TextUtils;

import com.didi365.dlnasupport.util.CommonLog;
import com.didi365.dlnasupport.util.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DlnaMediaModelFactory {

	private static final CommonLog log = LogFactory.createLog();
	
	public static final String PARAM_GET_URL = "param_metadata__url";
	public static final String PARAM_GET_OBJECT_CLASS = "param_metadata_object_class";
	public static final String PARAM_GET_TITLE = "param_metadata_title";
	public static final String PARAM_GET_ARTIST = "param_metadata_artist";
	public static final String PARAM_GET_ALBUM = "param_metadata_album";
	public static final String PARAM_GET_ALBUMICONURI = "param_metadata_album_uri";

	public static void pushMediaModelToIntent(Intent intent, DlnaMediaModel mediaInfo){
		intent.putExtra(PARAM_GET_URL, mediaInfo.getUrl());
		intent.putExtra(PARAM_GET_OBJECT_CLASS, mediaInfo.getObjectClass());
		intent.putExtra(PARAM_GET_TITLE, mediaInfo.getTitle());
		intent.putExtra(PARAM_GET_ARTIST, mediaInfo.getArtist());
		intent.putExtra(PARAM_GET_ALBUM, mediaInfo.getAlbum());
		intent.putExtra(PARAM_GET_ALBUMICONURI, mediaInfo.getAlbumUri()); 	
	}
	
	public static DlnaMediaModel createFromIntent(Intent intent){
		DlnaMediaModel mediaInfo = new DlnaMediaModel();	
		mediaInfo.setUrl(intent.getStringExtra(PARAM_GET_URL));
		mediaInfo.setObjectClass(intent.getStringExtra(PARAM_GET_OBJECT_CLASS));
		mediaInfo.setTitle(intent.getStringExtra(PARAM_GET_TITLE));
		mediaInfo.setArtist(intent.getStringExtra(PARAM_GET_ARTIST));
		mediaInfo.setAlbum(intent.getStringExtra(PARAM_GET_ALBUM));
		mediaInfo.setAlbumUri(intent.getStringExtra(PARAM_GET_ALBUMICONURI));	
		return mediaInfo;
	}
	
	public static DlnaMediaModel createFromMetaData(String metadata){
		DlnaMediaModel mediainfo = new DlnaMediaModel();
		DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		
		if (metadata.contains("&") && !metadata.contains("&amp;")){
			metadata = metadata.replace("&", "&amp;");
		}

		try {
			documentBuilder = dfactory.newDocumentBuilder();
			InputStream is = new ByteArrayInputStream(metadata.getBytes("UTF-8"));
			Document doc = documentBuilder.parse(is);
			mediainfo.setObjectClass(getElementValue(doc,"upnp:class"));
			mediainfo.setTitle(unicode2String(getElementValue(doc,"dc:title")));
			mediainfo.setAlbum(getElementValue(doc,"upnp:album"));
			mediainfo.setArtist(getElementValue(doc,"upnp:artist"));			
			mediainfo.setAlbumUri(getElementValue(doc,"upnp:albumArtURI"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mediainfo;
	}
	
	private static String getElementValue(Document doc , String element){
		NodeList containers = doc.getElementsByTagName(element);
		for (int j = 0; j < containers.getLength(); ++j) {		
			Node container = containers.item(j);
			NodeList childNodes = container.getChildNodes();
			if(childNodes.getLength()!=0){
				Node childNode = childNodes.item(0);
				return childNode.getNodeValue();
			}
		}
		return "";
	}


	private static String unicode2String(String unicode) {
		log.d( "unicode=" + unicode);
		StringBuilder string = new StringBuilder();
		if (unicode.contains("&#x")) {
			String[] splitS = unicode.split(" ");
			for (String split : splitS) {
				if (!TextUtils.isEmpty(split)) {
					if (split.contains("&#x")) {
						String[] hex = split.split("&#x");
						for (int i = 0; i < hex.length; i++) {
							log.d( "hex[" + i + "]=" + hex[i]);
							if (!TextUtils.isEmpty(hex[i])) {
								String[] split1 = hex[i].split(";");
								for (String endSp : split1) {
									if (!TextUtils.isEmpty(endSp)) {
										try {
											int data = Integer.parseInt(endSp, 16);
											string.append((char) data);
										} catch (NumberFormatException e) {
											string.append(endSp);
										}
									}
								}
							}
						}
					} else {
						string.append(split).append(" ");
					}
				}
			}
		} else if (unicode.contains("&#")) {
			String[] splitS = unicode.split(" ");
			for (String split : splitS) {
				if (!TextUtils.isEmpty(split)) {
					if (split.contains("&#")) {
						String[] hex = split.split("&#");
						for (int i = 0; i < hex.length; i++) {
							log.i("hex["+i+"]="+hex[i]);
							if (!TextUtils.isEmpty(hex[i])) {
								String[] split1 = hex[i].split(";");
								for (String endSp : split1) {
									if (!TextUtils.isEmpty(endSp)) {
										try {
											int data = Integer.parseInt(endSp, 10);
											string.append((char) data);
										} catch (NumberFormatException e) {
											string.append(endSp);
										}
									}
								}
							}
						}
					} else {
						string.append(split).append(" ");
					}
				}
			}
		} else {
			return unicode;
		}
		log.d("return string="+string);
		return string.toString();
	}
}



