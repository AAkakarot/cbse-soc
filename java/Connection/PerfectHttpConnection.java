/*
package Connection;

import com.sun.tools.javac.util.Log;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;


import static javax.management.timer.Timer.ONE_SECOND;

public class PerfectHttpConnection {

    private Object doSendRequest(final int requestCode, String url, final Object params, final String sessionId, final String requestType, final Activity parentActivity) {
        URL myurl;
        Log.v("sessionId", sessionId + "");
        HttpsURLConnection httpsURLConnection = null;
        try {
            if (requestType.equalsIgnoreCase("GET")) {
                if (params.toString().length() >= 1) {
                    if (url.contains("?")) {
                        url = (url + params.toString());
                    } else {
                        url = (url + "?" + params.toString());
                    }
                }
            }
            myurl = new URL(url);
            Log.v("RequestCode, URL", requestCode + " : " + url);
            httpsURLConnection = (HttpsURLConnection) myurl.openConnection();
            httpsURLConnection.setRequestMethod(requestType);
            httpsURLConnection.setUseCaches(true);
            if (isOnline(parentActivity)) {
                httpsURLConnection.addRequestProperty("Cache-Control", "max-age=0");
            } else {
                httpsURLConnection.setUseCaches(true);
                httpsURLConnection.addRequestProperty("Cache-Control", "max-stale=" + CACHE_STALE_TIME_OUT);
                httpsURLConnection.addRequestProperty("Cache-Control", "only-if-cached");
            }

            httpsURLConnection.setConnectTimeout((int) (20 * ONE_SECOND));
            httpsURLConnection.setReadTimeout((int) (20 * ONE_SECOND));
            httpsURLConnection.setInstanceFollowRedirects(true);
            httpsURLConnection.setRequestProperty("Content-Type", CONTENT_TYPE_APPLICATION_JSON);
            if (sessionId != null) {
                httpsURLConnection.setRequestProperty("sessionId", sessionId);
            }
            httpsURLConnection.setDoInput(true);
            if (!requestType.equalsIgnoreCase("GET")) {
                Log.v("RequestData", "" + params.toString());
                httpsURLConnection.setDoOutput(true);
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new OutputStreamWriter(httpsURLConnection.getOutputStream(), "UTF-8"));
                    writer.write(params.toString());
                    writer.flush();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(writer != null){
                        try {
                            writer.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }

            }
            httpsURLConnection.connect();
        } catch (Exception e) {
            Log.v("Ex", "1");
            e.printStackTrace();
            handleException(requestCode, e, parentActivity);
            return null;
        }

        //---------------------READING THE RESPONSE---------------------------//

        BufferedReader bReader = null;
        try {
            final String newSessionId = httpsURLConnection.getHeaderField("sessionId");
            final int httpResponseCode = httpsURLConnection.getResponseCode();
            Log.v("Req, Response codes", requestCode+", "+httpResponseCode);

            if(httpResponseCode == 504 && !LegionUtils.isOnline(parentActivity)){
                parentActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        hideProgressDialog();
                        showOfflineDialog(parentActivity);
                    }
                });
                return null;
            }

            if (httpResponseCode == 401)  {
                parentActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        hideProgressDialog();


                    }
                });
                return null;
            } else if ((httpResponseCode == 400 || (httpResponseCode >= 500 && httpResponseCode <= 599)) && !(parentActivity instanceof CreateAccountActivity)) {
                parentActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        hideProgressDialog();

                        networkCallback.onFailure(requestCode, null);
                    }
                });
                return null;
            } else if ((httpResponseCode >= 500 && httpResponseCode <= 599) && (parentActivity instanceof CreateAccountActivity)) {
                parentActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        networkCallback.onFailure(requestCode, null);
                    }
                });
                return null;
            }

            InputStream inputStream;
            try {
                inputStream = httpsURLConnection.getInputStream();
            }catch (FileNotFoundException e){
                e.printStackTrace();
                inputStream = httpsURLConnection.getErrorStream();
            }

            if (inputStream != null) {
                bReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String inputLine;
                final StringBuffer response = new StringBuffer();
                while ((inputLine = bReader.readLine()) != null) {
                    response.append(inputLine);
                }
                bReader.close();

                parentActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.v("RESPONSE " + requestCode, response.toString());
                        networkCallback.onSuccess(requestCode, response.toString(), newSessionId);
                    }
                });
            }

        } catch (Exception e) {
            Log.v("Ex", "2");
            e.printStackTrace();
            handleException(requestCode, e, parentActivity);
        } finally {
            try {
                if (bReader != null) {
                    bReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void handleException(final int requestCode, Exception error, final Activity parentActivity) {
        final String errorResponse;
        if (error instanceof TimeoutException || error instanceof SocketTimeoutException || error instanceof UnknownHostException) {
            errorResponse = "Your request has been timed out. Please try again later.";
        } else if (error instanceof SSLException || error instanceof ConnectException) {
            errorResponse = null;
            parentActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    hideProgressDialog();
                    showOfflineDialog(parentActivity);
                }
            });
        } */
/*else if (error instanceof FileNotFoundException) {
        errorResponse = "Invalid Request.\nPlease try again later.";
    } *//*
else if (error instanceof IOException) {
            errorResponse = "Something went wrong. Please try again later.";
        } else if (error instanceof JSONException) {
            errorResponse = "Unexpected response.\nPlease try again later.";
        } else {
            errorResponse = null;
            parentActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    hideProgressDialog();
                    showOfflineDialog(parentActivity);
                }
            });
        }
        Log.v("FAILURE ERR RESPONSE " + requestCode, errorResponse + "");
        parentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                networkCallback.onFailure(requestCode, errorResponse);
            }
        });
    }
}

*/
