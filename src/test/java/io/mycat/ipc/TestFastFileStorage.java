package io.mycat.ipc;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * 快速稳健存储
 */
public class TestFastFileStorage {

	@Test
	public void testWriteAndRead() throws Exception {
		long start = System.currentTimeMillis();
		FastestFileStorage st = new FastestFileStorage("mm.data", 200 * 1024 * 1024L, true, 1024 * 1024);
		for (int i = 0; i < 10_0000; i++) {
			String data = "hellow " + i;
			int writeResult = st.writeData(data.getBytes());
			if (writeResult == -1) {
				System.out.println("full " + i);
				break;
			} else if (writeResult == 0) {
				System.out.println("cant't write " + i);
				break;
			} else {
				if (i % 1000 == 0)
					System.out.println("write success " + i);
			}
		}
		st.close();
		System.out.println(" closed  : " + (System.currentTimeMillis() - start));

		st = new FastestFileStorage("mm.data", 100 * 1024 * 1024L, false, 1024 * 1024);

	}

	@Test
	public void testNormal() throws Exception {
		long start = System.currentTimeMillis();
		File file = new File("test_normal.txt");
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
		for (int i = 0; i < 10_0000; i++) {
			String data = "hellow " + i;
			out.write(data.getBytes());
			if (i % 1000 == 0) {
				System.out.println("write success " + i);
			}
		}
		out.close();
		System.out.println(" closed  : " + (System.currentTimeMillis() - start));
	}
}
