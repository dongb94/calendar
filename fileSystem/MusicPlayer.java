package fileSystem;

public class MusicPlayer {
	public void playMusicAndVideo(String path) throws Exception {
			String[] strarr;
		String newPath = "";
		strarr = path.split("/");
		for (int i = 0; i < strarr.length; i++) {
			newPath += strarr[i] + "\\\\";
		}
		newPath=newPath.substring(0, newPath.length()-2);
		if (newPath == null) {
			System.out.println("��θ��� ��Ȯ���� �ʽ��ϴ�(in MusicPlayer");
		} else {
			Runtime run = Runtime.getRuntime();
			String ss = String.format("C:\\Program Files\\Windows Media Player\\wmplayer.exe  %s", newPath);
			run.exec(ss);
		}
	}
}
