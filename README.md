I18N Cordova Plugin for Android
=======================================
This plugin allows you to internationalize your application 

Adding the Plugin to your project
=================================

    To install the plugin, copy i18nplugin.js to your project's www/js folder and include a reference to it in your html files, you will also need jquery.
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="cordova-2.4.0.js"></script>
    <script type="text/javascript" src="js/i18nplugin.js"></script>

    Create a folder called 'com/zeosworld/cordova' within your project's src folder and copy I18NPlugin.java file into that new folder.

    Add a plugin line to res/xml/plugins.xml
    <plugin name="I18Plugin" value="com.zeosworld.cordova.I18NPlugin"/>
    
Using the plugin
================
Just add i18N to the tags you want to translate.
The following things happen:
    If you have a p the text in the p is lowercased and used as key in strings.xml
    if you gave an input type text, we will replace the value.

Basically it will use as key in strings.xml the value returned by jquery(elem).text()

