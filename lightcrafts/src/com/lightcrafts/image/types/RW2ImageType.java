/* Copyright (C) 2005-2011 Fabio Riccardi */

package com.lightcrafts.image.types;

import java.io.IOException;

import com.lightcrafts.image.BadImageFileException;
import com.lightcrafts.image.ImageInfo;
import com.lightcrafts.image.metadata.ImageMetadataReader;
import com.lightcrafts.image.metadata.MetadataUtil;
import com.lightcrafts.image.metadata.TIFFMetadataReader;

/**
 * A {@code RW2ImageType} is-a {@link RawImageType} for Panasonic raw images.
 *
 * @author Paul J. Lucas [paul@lightcrafts.com]
 */
public final class RW2ImageType extends RawImageType {

    ////////// public /////////////////////////////////////////////////////////

    /** The singleton instance of {@code RW2ImageType}. */
    public static final RW2ImageType INSTANCE = new RW2ImageType();

    /**
     * {@inheritDoc}
     */
    public String[] getExtensions() {
        return EXTENSIONS;
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return "Panasonic";
    }

    // through dcraw, fast enough...
    public boolean hasFastPreview() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public void readMetadata( ImageInfo imageInfo )
        throws BadImageFileException, IOException
    {
        final ImageMetadataReader reader = new TIFFMetadataReader( imageInfo );
        MetadataUtil.removePreviewMetadataFrom( reader.readMetadata() );
    }

    ////////// private ////////////////////////////////////////////////////////

    /**
     * Construct an {@code RW2ImageType}.
     * The constructor is {@code private} so only the singleton instance
     * can be constructed.
     */
    private RW2ImageType() {
        // do nothing
    }

    /**
     * All the possible filename extensions for Panasonic raw files.  All must
     * be lower case and the preferred one must be first.
     */
    private static final String EXTENSIONS[] = {
        "rw2"
    };
}
/* vim:set et sw=4 ts=4: */
