var i18nPlugin = function() {
}

i18nPlugin.prototype.init = function() {
    var self = this;
    document.addEventListener('deviceready', function() {self.initTranslation();}, false)
};

i18nPlugin.prototype.initTranslation = function() {
    var self = this;
    this.translate(null, 'asd');
    $('[i18N]').each(function(idx, htmlElem) {
	var elem = $(htmlElem);
	if (elem.is('input') && (elem.attr('type') == 'text' || !elem.attr('type'))) {
	    //it's an input text we might need to i18n the value instead of the text
	    if (elem.attr('value'))
		self.translate(elem, 'val', elem.val());
	}
	if (elem.text())
	    self.translate(elem, 'text', elem.text());
    });
};

i18nPlugin.prototype.translate = function(elem,fn ,value) {
    var args = [value];
    cordova.exec(function(returned) {
	console.log('set returned: ' + returned );
	if (fn == 'val')
	    elem.val(returned);    
	else if (fn == 'text') 
	    elem.text(returned);
	
    }, function(e) {console.log(e);}, "I18Plugin", "translate", args);
}

i18n = function(string) {
    window.plugins.i18n.translate(string)
}

cordova.addConstructor(function() {
    if (!window.cordova) {
	window.cordova = cordova;
    }

    if (!window.plugins)
	window.plugins = {};
    window.plugins.i18n = new i18nPlugin();
    window.plugins.i18n.init();
});
