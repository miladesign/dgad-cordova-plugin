package ir.dgad.miladesign;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.dgad.*;

public class DgadPlugin  extends CordovaPlugin {
	private static CallbackContext callbackContextKeepCallback = null;
	private static Activity mActivity = null;
	public CordovaInterface cordova = null;
	private static final int POSITION_TOP = 0;
	private static final int POSITION_BOTTOM = 1;
	private static final String LOG_TAG = "MilaDesign Dgad";
	private FrameLayout bannerFrame;
	private AdView bannerAd;

	@Override
	public void initialize (CordovaInterface initCordova, CordovaWebView webView) {
		 Log.e (LOG_TAG, "initialize");
		  cordova = initCordova;
		  super.initialize (cordova, webView);
	}
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext CallbackContext) throws JSONException {
		if (action.equals("addBanner")) {
			addBanner(action, args, CallbackContext);
			return true;
		}
		if (action.equals("removeBanner")) {
			removeBanner(action, args, CallbackContext);
			return true;
		}
		if (action.equals("setTest")) {
			setTest(action, args, CallbackContext);
			return true;
		}
		if (action.equals("setDisabled")) {
			setDisabled(action, args, CallbackContext);
			return true;
		}
		if (action.equals("randomPopup")) {
			randomPopup(action, args, CallbackContext);
			return true;
		}
		if (action.equals("fullAd")) {
			fullAd(action, args, CallbackContext);
			return true;
		}
		if (action.equals("appWall")) {
			appWall(action, args, CallbackContext);
			return true;
		}
		if (action.equals("initVideo")) {
			initVideo(action, args, CallbackContext);
			return true;
		}
		if (action.equals("initAudio")) {
			initAudio(action, args, CallbackContext);
			return true;
		}
		if (action.equals("showVideo")) {
			showVideo(action, args, CallbackContext);
			return true;
		}
		if (action.equals("cancelableVideo")) {
			cancelableVideo(action, args, CallbackContext);
			return true;
		}
		if (action.equals("showAudio")) {
			showAudio(action, args, CallbackContext);
			return true;
		}
		if (action.equals("setPopupListener")) {
			setPopupListener(action, args, CallbackContext);
			return true;
		}
		if (action.equals("setOnAvailableVideoListener")) {
			setOnAvailableVideoListener(action, args, CallbackContext);
			return true;
		}
		if (action.equals("setOnVideoDownloadCompleteListener")) {
			setOnVideoDownloadCompleteListener(action, args, CallbackContext);
			return true;
		}
		if (action.equals("setOnAvailableAudioListener")) {
			setOnAvailableAudioListener(action, args, CallbackContext);
			return true;
		}
		if (action.equals("setOnAudioDownloadCompleteListener")) {
			setOnAudioDownloadCompleteListener(action, args, CallbackContext);
			return true;
		}
		if (action.equals("setOnAudioResultListener")) {
			setOnAudioResultListener(action, args, CallbackContext);
			return true;
		}
		if (action.equals("isReadyVideoToShow")) {
			isReadyVideoToShow(action, args, CallbackContext);
			return true;
		}
		return false;
	}
	
	private void addBanner(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final int position = args.getInt(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					_addBanner(position);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void _addBanner(int position) throws JSONException {
	    mActivity = cordova.getActivity();
	    int i = position;
	    bannerFrame = new FrameLayout(mActivity);
	    FrameLayout.LayoutParams fLayoutParams = new FrameLayout.LayoutParams(-2, -2);
	    switch (i) {
		    case POSITION_TOP:
		    	fLayoutParams.gravity = 49;
		    	break;
		    case POSITION_BOTTOM:
		    	fLayoutParams.gravity = 81;
	    }
	    bannerAd = new AdView(mActivity);
	    removeBanner(null, null, null);
	    bannerFrame.setLayoutParams(fLayoutParams);
	    ((ViewGroup)DgadPlugin.this.getParentGroup().getParent()).addView(bannerFrame, 1);
	    bannerFrame.addView(bannerAd);
	}
	
	private void removeBanner(String action, JSONArray args, CallbackContext callbackContext) {
	    if ((this.bannerAd == null) || (this.bannerFrame == null))
	        return;
	      if (mActivity != null) {
	      	mActivity.runOnUiThread(new Runnable() {
	          public void run() {
	            ViewGroup viewGroup;
	            if (((viewGroup = DgadPlugin.this.getParentGroup()) != null) && ((viewGroup instanceof ViewGroup)) && (((ViewGroup)viewGroup.getParent()).getChildAt(1) != null))
	              ((ViewGroup)viewGroup.getParent()).removeViewAt(1);
	          }
	        });
	        if (callbackContext != null)
	      	  callbackContext.success();
	      }
	}

	private ViewGroup getParentGroup() {
	    try {
	      return (ViewGroup)this.webView.getClass().getMethod("getView", new Class[0]).invoke(this.webView, new Object[0]);
	    } catch (Exception ex) {
	    	try {
	    		return (ViewGroup)this.webView.getClass().getMethod("getParent", new Class[0]).invoke(this.webView, new Object[0]);
	    	} catch (Exception e) {
	    		e.printStackTrace(); 
	        }
	    }
	    return null;
	}
	

	private void setTest(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final boolean mode = args.getBoolean(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_setTest(mode);
			}
		});
	}

	private void _setTest(boolean mode) {
	    mActivity = cordova.getActivity();
	    Dgad.setTest(mode);
	}
	

	private void setDisabled(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final boolean mode = args.getBoolean(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_setDisabled(mode);
			}
		});
	}

	private void _setDisabled(boolean mode) {
	    mActivity = cordova.getActivity();
	    Dgad.setDisabled(mode);
	}

	private void randomPopup(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_randomPopup();
			}
		});
	}

	private void _randomPopup() {
	    mActivity = cordova.getActivity();
	    Dgad.showRandomPopup(mActivity);
	}

	private void fullAd(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_fullAd();
			}
		});
	}

	private void _fullAd() {
	    mActivity = cordova.getActivity();
	    Dgad.showFullAd(mActivity);
	}

	private void appWall(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_appWall();
			}
		});
	}

	private void _appWall() {
	    mActivity = cordova.getActivity();
	    Dgad.showAppWall(mActivity);
	}

	private void initVideo(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String token = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_initVideo(token);
			}
		});
	}

	private void _initVideo(String token) {
	    mActivity = cordova.getActivity();
	    DgadInit.init(mActivity, token);
	}

	private void initAudio(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String token = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_initAudio(token);
			}
		});
	}

	private void _initAudio(String token) {
	    mActivity = cordova.getActivity();
	    Dgad.initAudio(mActivity, token);
	}
	
	private void cancelableVideo(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final boolean mode = args.getBoolean(0);
		final String message = args.getString(1);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_cancelableVideo(mode,message);
			}
		});
	}

	private void _cancelableVideo(boolean mode, String message) {
	    mActivity = cordova.getActivity();
	    Dgad.cancelableVideo(mActivity, mode, message);
	}
	
	private void showAudio(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_showAudio();
			}
		});
	}

	private void _showAudio() {
	    mActivity = cordova.getActivity();
	    Dgad.showAudio(mActivity);
	}
	
	private void showVideo(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_showVideo();
			}
		});
	}

	private void _showVideo() {
	    mActivity = cordova.getActivity();
	    DgadInit.showVideo(mActivity, new VideoListener());
	}
	
	class VideoListener implements DgadVideoListener {
		@Override
		public void setResult(int result) {
			if (result==1) {
				PluginResult pr = new PluginResult(PluginResult.Status.OK, "onVideoOK");
				pr.setKeepCallback(true);
				DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
			} else if (result==-1) {
				PluginResult pr = new PluginResult(PluginResult.Status.OK, "onVideoCanceled");
				pr.setKeepCallback(true);
				DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
			} else if (result==-2) {
				PluginResult pr = new PluginResult(PluginResult.Status.OK, "onVideoFailed");
				pr.setKeepCallback(true);
				DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
			}
		}
	}
	

	private void setPopupListener(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_setPopupListener();
			}
		});
	}

	private void _setPopupListener() {
	    mActivity = cordova.getActivity();
	    Dgad.setPopupListener(new PopupListener() {

			@Override
			public void AdCancel() {
				PluginResult pr = new PluginResult(PluginResult.Status.OK, "AdCancel");
				pr.setKeepCallback(true);
				DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
			}

			@Override
			public void AdClick() {
				PluginResult pr = new PluginResult(PluginResult.Status.OK, "AdClick");
				pr.setKeepCallback(true);
				DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
			}

			@Override
			public void AdFailed() {
				PluginResult pr = new PluginResult(PluginResult.Status.OK, "AdFailed");
				pr.setKeepCallback(true);
				DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
			}

			@Override
			public void AdReq() {
				PluginResult pr = new PluginResult(PluginResult.Status.OK, "AdReq");
				pr.setKeepCallback(true);
				DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
			}

			@Override
			public void AdShow() {
				PluginResult pr = new PluginResult(PluginResult.Status.OK, "AdShow");
				pr.setKeepCallback(true);
				DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
			}
	    	
	    });
	}
	

	private void setOnAvailableVideoListener(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_setOnAvailableVideoListener();
			}
		});
	}

	private void _setOnAvailableVideoListener() {
	    mActivity = cordova.getActivity();
	    Dgad.setOnAvailableVideoListener(mActivity, new OnAvailableVideoListener() {
	        @Override
	        public void onResponse(boolean isAvailable) {
				if (isAvailable=true) {
					PluginResult pr = new PluginResult(PluginResult.Status.OK, "onVideoAvailable");
					pr.setKeepCallback(true);
					DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
				} else {
					PluginResult pr = new PluginResult(PluginResult.Status.OK, "onVideoNotAvailable");
					pr.setKeepCallback(true);
					DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
				}
	        }
	    });
	}
	

	private void setOnVideoDownloadCompleteListener(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_setOnVideoDownloadCompleteListener();
			}
		});
	}

	private void _setOnVideoDownloadCompleteListener() {
	    mActivity = cordova.getActivity();
	    Dgad.setOnVideoDownloadCompleteListener(mActivity, new OnVideoDownloadCompleteListener() {
			@Override
			public void onResponse(boolean isReady) {
				if (isReady=true) {
					PluginResult pr = new PluginResult(PluginResult.Status.OK, "onVideoDownload");
					pr.setKeepCallback(true);
					DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
				} else {
					PluginResult pr = new PluginResult(PluginResult.Status.OK, "onVideoNotDownload");
					pr.setKeepCallback(true);
					DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
				}
			}
	    });
	}
	

	private void setOnAvailableAudioListener(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_setOnAvailableAudioListener();
			}
		});
	}

	private void _setOnAvailableAudioListener() {
	    mActivity = cordova.getActivity();
	    Dgad.setOnAvailableAudioListener(mActivity, new OnAvailableAudioListener() {
	        @Override
	        public void onResponse(boolean isAvailable) {
				if (isAvailable=true) {
					PluginResult pr = new PluginResult(PluginResult.Status.OK, "onAudioAvailable");
					pr.setKeepCallback(true);
					DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
				} else {
					PluginResult pr = new PluginResult(PluginResult.Status.OK, "onAudioNotAvailable");
					pr.setKeepCallback(true);
					DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
				}
	        }
	    });
	}
	

	private void setOnAudioDownloadCompleteListener(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_setOnAudioDownloadCompleteListener();
			}
		});
	}

	private void _setOnAudioDownloadCompleteListener() {
	    mActivity = cordova.getActivity();
	    Dgad.setOnAudioDownloadCompleteListener(mActivity, new OnAudioDownloadCompleteListener() {
			@Override
			public void onResponse(boolean isReady) {
				if (isReady=true) {
					PluginResult pr = new PluginResult(PluginResult.Status.OK, "onAudioDownload");
					pr.setKeepCallback(true);
					DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
				} else {
					PluginResult pr = new PluginResult(PluginResult.Status.OK, "onAudioNotDownload");
					pr.setKeepCallback(true);
					DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
				}
			}
	    });
	}
	private void setOnAudioResultListener(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_setOnAudioResultListener();
			}
		});
	}

	private void _setOnAudioResultListener() {
	    mActivity = cordova.getActivity();
	    Dgad.setOnAudioResultListener(mActivity, new OnAudioResultListener() {

			@Override
			public void onResult(int result) {
				if (result==1) {
					PluginResult pr = new PluginResult(PluginResult.Status.OK, "onAudioOK");
					pr.setKeepCallback(true);
					DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
				} else {
					PluginResult pr = new PluginResult(PluginResult.Status.OK, "onAudioFailed");
					pr.setKeepCallback(true);
					DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
				}
			}
	    });
	}
	private void isReadyVideoToShow(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_isReadyVideoToShow();
			}
		});
	}

	private void _isReadyVideoToShow() {
	    mActivity = cordova.getActivity();
	    Boolean result = Dgad.isReadyVideoToShow(mActivity);
		if (result==true) {
			PluginResult pr = new PluginResult(PluginResult.Status.OK, "ReadyVideoToShow");
			pr.setKeepCallback(true);
			DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
		} else {
			PluginResult pr = new PluginResult(PluginResult.Status.OK, "NotReadyVideoToShow");
			pr.setKeepCallback(true);
			DgadPlugin.callbackContextKeepCallback.sendPluginResult(pr);
		}
	}
}