# RetinaTag

The Grails Retina Tag plugin adds retina tag image support to the asset pipeline `<asset:image/>` taglib.
RetinaTag resolves this by extending `<asset:image/>` to create a `hidpi_src` attribute with the retina image path if it exists.

## Installation

Add retina tag to your build config

```
plugins {
	compile ':retina-tag:1.1.0'
}
```

### Grals 3

```
dependencies {
	compile 'com.bertramlabs.plugins:retina-tag:3.0.0'
}
```


## Usage

Add `retina_tag.js` to your application.js file after including jQuery:

```
//=require retina_tag
```

Add double pixel resolution images in your assets directory with the @2x modifier

    logo.png
    logo@2x.png

Be sure to also specify the base dimensions in your `image_tag` calls:

```
<asset:image src='logo.png' height=50/>
```

Awesome right?

### Forcing Refresh after loading dynamic content
Retina tag listens to the global event on document called `retina_tag:refresh`. Firing this event will force retina_tag to rescan the dom for images and update their image src if necessary. Useful if loading content dynamically. **Note:** retina_tag automatically supports turbolinks.

### Override Hidpi src attribute
In some cases it becomes necessary to override the data-hidpi-src attribute and skip asset pipeline. A good example of this might be to load a users profile picture which is stored elsewhere.

```
	<asset:image src="${user.photo.url('medium')}" data-hidpi-src="${user.photo.url('medium_2x')" height="75%" width="75"/>
```


## Contributing

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Added some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request

##License
This project is licensed under the APACHE License.
