module.exports = {
	Position: {
        TOP: 0,
        BOTTOM: 1
    },
    AddBanner: function(position) {
        cordova.exec(
			null,
			null,
            'DgadPlugin',
            'addBanner',
            [position]
        ); 
    },
    RemoveBanner: function() {
        cordova.exec(
			null,
			null,
            'DgadPlugin',
            'removeBanner',
            []
        ); 
    },
    SetTest: function(mode) {
        cordova.exec(
			null,
			null,
            'DgadPlugin',
            'setTest',
            [mode]
        ); 
    },
    SetDisable: function(mode) {
        cordova.exec(
			null,
			null,
            'DgadPlugin',
            'setDisabled',
            [mode]
        ); 
    },
    RandomPopup: function() {
        cordova.exec(
			null,
			null,
            'DgadPlugin',
            'randomPopup',
            []
        ); 
    },
    FullAd: function() {
        cordova.exec(
			null,
			null,
            'DgadPlugin',
            'fullAd',
            []
        ); 
    },
    AppWall: function() {
        cordova.exec(
			null,
			null,
            'DgadPlugin',
            'appWall',
            []
        ); 
    },
    InitVideo: function(token) {
        cordova.exec(
			null,
			null,
            'DgadPlugin',
            'initVideo',
            [token]
        ); 
    },
	ShowVideo: function () {
        var self = this;
        cordova.exec(
             function (result) {
                if (typeof result == "string") {
                    if (result == "onVideoOK") {
                        if (self.onVideoOK) {
                            self.onVideoOK();
                        }
                    }
                    if (result == "onVideoCanceled") {
                        if (self.onVideoCanceled) {
                            self.onVideoCanceled();
                        }
                    }
                    if (result == "onVideoFailed") {
                        if (self.onVideoFailed) {
                            self.onVideoFailed();
                        }
                    }
                }
            },
            null,
            'DgadPlugin',
            'showVideo',
            []
        );
    },
    CancelableVideo: function(mode,message) {
        cordova.exec(
			null,
			null,
            'DgadPlugin',
            'cancelableVideo',
            [mode,message]
        ); 
    },
    InitAudio: function(token) {
        cordova.exec(
			null,
			null,
            'DgadPlugin',
            'initAudio',
            [token]
        ); 
    },
	ShowAudio: function () {
        var self = this;
        cordova.exec(
            null,
            null,
            'DgadPlugin',
            'showAudio',
            []
        );
    },
	SetPopupListener: function () {
        var self = this;
        cordova.exec(
             function (result) {
                if (typeof result == "string") {
                    if (result == "AdCancel") {
                        if (self.AdCancel) {
                            self.AdCancel();
                        }
                    }
                    if (result == "AdClick") {
                        if (self.AdClick) {
                            self.AdClick();
                        }
                    }
                    if (result == "AdFailed") {
                        if (self.AdFailed) {
                            self.AdFailed();
                        }
                    }
                    if (result == "AdReq") {
                        if (self.AdReq) {
                            self.AdReq();
                        }
                    }
                    if (result == "AdShow") {
                        if (self.AdShow) {
                            self.AdShow();
                        }
                    }
                }
            },
            null,
            'DgadPlugin',
            'setPopupListener',
            []
        );
    },
	SetOnAvailableVideoListener: function () {
        var self = this;
        cordova.exec(
             function (result) {
                if (typeof result == "string") {
                    if (result == "onVideoAvailable") {
                        if (self.onVideoAvailable) {
                            self.onVideoAvailable();
                        }
                    }
                    if (result == "onVideoNotAvailable") {
                        if (self.onVideoNotAvailable) {
                            self.onVideoNotAvailable();
                        }
                    }
                }
            },
            null,
            'DgadPlugin',
            'setOnAvailableVideoListener',
            []
        );
    },
	SetOnAvailableAudioListener: function () {
        var self = this;
        cordova.exec(
             function (result) {
                if (typeof result == "string") {
                    if (result == "onAudioAvailable") {
                        if (self.onAudioAvailable) {
                            self.onAudioAvailable();
                        }
                    }
                    if (result == "onAudioNotAvailable") {
                        if (self.onAudioNotAvailable) {
                            self.onAudioNotAvailable();
                        }
                    }
                }
            },
            null,
            'DgadPlugin',
            'setOnAvailableAudioListener',
            []
        );
    },
	SetOnVideoDownloadCompleteListener: function () {
        var self = this;
        cordova.exec(
             function (result) {
                if (typeof result == "string") {
                    if (result == "onVideoDownload") {
                        if (self.onVideoDownload) {
                            self.onVideoDownload();
                        }
                    }
                    if (result == "onVideoNotDownload") {
                        if (self.onVideoNotDownload) {
                            self.onVideoNotDownload();
                        }
                    }
                }
            },
            null,
            'DgadPlugin',
            'setOnVideoDownloadCompleteListener',
            []
        );
    },
	SetOnAudioDownloadCompleteListener: function () {
        var self = this;
        cordova.exec(
             function (result) {
                if (typeof result == "string") {
                    if (result == "onAudioDownload") {
                        if (self.onAudioDownload) {
                            self.onAudioDownload();
                        }
                    }
                    if (result == "onAudioNotDownload") {
                        if (self.onAudioNotDownload) {
                            self.onAudioNotDownload();
                        }
                    }
                }
            },
            null,
            'DgadPlugin',
            'setOnAudioDownloadCompleteListener',
            []
        );
    },
	SetOnAudioResultListener: function () {
        var self = this;
        cordova.exec(
             function (result) {
                if (typeof result == "string") {
                    if (result == "onAudioOK") {
                        if (self.onAudioOK) {
                            self.onAudioOK();
                        }
                    }
                    if (result == "onAudioFailed") {
                        if (self.onAudioFailed) {
                            self.onAudioFailed();
                        }
                    }
                }
            },
            null,
            'DgadPlugin',
            'setOnAudioResultListener',
            []
        );
    },
	IsReadyVideoToShow: function () {
        var self = this;
        cordova.exec(
             function (result) {
                if (typeof result == "string") {
                    if (result == "ReadyVideoToShow") {
                        if (self.ReadyVideoToShow) {
                            self.ReadyVideoToShow();
                        }
                    }
                    if (result == "NotReadyVideoToShow") {
                        if (self.NotReadyVideoToShow) {
                            self.NotReadyVideoToShow();
                        }
                    }
                }
            },
            null,
            'DgadPlugin',
            'isReadyVideoToShow',
            []
        );
    },
    onAudioDownload: null,
    onAudioNotDownload: null,
    onAudioAvailable: null,
    onAudioNotAvailable: null,
    onVideoDownload: null,
    onVideoNotDownload: null,
    onVideoAvailable: null,
    onVideoNotAvailable: null,
    AdCancel: null,
    AdClick: null,
    AdFailed: null,
    AdReq: null,
    AdShow: null,
    onVideoOK: null,
    onVideoCanceled: null,
    onVideoFailed: null,
    onAudioOK: null,
    onAudioFailed: null,
    ReadyVideoToShow: null,
    NotReadyVideoToShow: null
};