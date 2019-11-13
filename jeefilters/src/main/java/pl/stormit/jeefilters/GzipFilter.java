package pl.stormit.jeefilters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

//@WebFilter(urlPatterns = "/*")
public class GzipFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse httpResponse = (HttpServletResponse) res;

		if (acceptsGZipEncoding(httpRequest)) {
			httpResponse.addHeader("Content-Encoding", "gzip");
			GZipServletResponseWrapper gzipResponse =
					new GZipServletResponseWrapper(httpResponse);
			chain.doFilter(req, gzipResponse);
			gzipResponse.close();
		} else {
			chain.doFilter(req, res);
		}
	}

	private boolean acceptsGZipEncoding(HttpServletRequest httpRequest) {
		String acceptEncoding =
				httpRequest.getHeader("Accept-Encoding");

		return acceptEncoding != null &&
				acceptEncoding.indexOf("gzip") != -1;
	}

//	private static void decompressGzipFile(String gzipFile, String newFile) {
//		try {
//			FileInputStream fis = new FileInputStream(gzipFile);
//			GZIPInputStream gis = new GZIPInputStream(fis);
//			FileOutputStream fos = new FileOutputStream(newFile);
//			byte[] buffer = new byte[1024];
//			int len;
//			while ((len = gis.read(buffer)) != -1) {
//				fos.write(buffer, 0, len);
//			}
//			//close resources
//			fos.close();
//			gis.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	private static void compressGzipFile(String file, String gzipFile) {
//		try {
//			FileInputStream fis = new FileInputStream(file);
//			FileOutputStream fos = new FileOutputStream(gzipFile);
//			GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
//			byte[] buffer = new byte[1024];
//			int len;
//			while ((len = fis.read(buffer)) != -1) {
//				gzipOS.write(buffer, 0, len);
//			}
//			//close resources
//			gzipOS.close();
//			fos.close();
//			fis.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}


	static class GZipServletResponseWrapper extends HttpServletResponseWrapper {

		private GZipServletOutputStream gzipOutputStream = null;
		private PrintWriter printWriter = null;

		public GZipServletResponseWrapper(HttpServletResponse response)
				throws IOException {
			super(response);
		}

		public void close() throws IOException {

			//PrintWriter.close does not throw exceptions.
			//Hence no try-catch block.
			if (this.printWriter != null) {
				this.printWriter.close();
			}

			if (this.gzipOutputStream != null) {
				this.gzipOutputStream.close();
			}
		}


		/**
		 * Flush OutputStream or PrintWriter
		 *
		 * @throws IOException
		 */

		@Override
		public void flushBuffer() throws IOException {

			//PrintWriter.flush() does not throw exception
			if (this.printWriter != null) {
				this.printWriter.flush();
			}

			IOException exception1 = null;
			try {
				if (this.gzipOutputStream != null) {
					this.gzipOutputStream.flush();
				}
			} catch (IOException e) {
				exception1 = e;
			}

			IOException exception2 = null;
			try {
				super.flushBuffer();
			} catch (IOException e) {
				exception2 = e;
			}

			if (exception1 != null) throw exception1;
			if (exception2 != null) throw exception2;
		}

		@Override
		public ServletOutputStream getOutputStream() throws IOException {
			if (this.printWriter != null) {
				throw new IllegalStateException(
						"PrintWriter obtained already - cannot get OutputStream");
			}
			if (this.gzipOutputStream == null) {
				this.gzipOutputStream = new GZipServletOutputStream(
						getResponse().getOutputStream());
			}
			return this.gzipOutputStream;
		}

		@Override
		public PrintWriter getWriter() throws IOException {
			if (this.printWriter == null && this.gzipOutputStream != null) {
				throw new IllegalStateException(
						"OutputStream obtained already - cannot get PrintWriter");
			}
			if (this.printWriter == null) {
				this.gzipOutputStream = new GZipServletOutputStream(
						getResponse().getOutputStream());
				this.printWriter = new PrintWriter(new OutputStreamWriter(
						this.gzipOutputStream, getResponse().getCharacterEncoding()));
			}
			return this.printWriter;
		}


		@Override
		public void setContentLength(int len) {
			//ignore, since content length of zipped content
			//does not match content length of unzipped content.
		}
	}

	static class GZipServletOutputStream extends ServletOutputStream {
		private GZIPOutputStream gzipOutputStream = null;

		public GZipServletOutputStream(OutputStream output)
				throws IOException {
			super();
			this.gzipOutputStream = new GZIPOutputStream(output);
		}

		@Override
		public void close() throws IOException {
			this.gzipOutputStream.close();
		}

		@Override
		public void flush() throws IOException {
			this.gzipOutputStream.flush();
		}

		@Override
		public void write(byte b[]) throws IOException {
			this.gzipOutputStream.write(b);
		}

		@Override
		public void write(byte b[], int off, int len) throws IOException {
			this.gzipOutputStream.write(b, off, len);
		}

		@Override
		public void write(int b) throws IOException {
			this.gzipOutputStream.write(b);
		}

		@Override
		public boolean isReady() {
			return false;
		}

		@Override
		public void setWriteListener(WriteListener writeListener) {

		}
	}
}
