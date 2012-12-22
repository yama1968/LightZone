/*
 * @(#)UProperty.java	1.3 05/11/17
 *
 * Portions Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 *******************************************************************************
 * (C) Copyright IBM Corp. 1996-2005 - All Rights Reserved                     *
 *                                                                             *
 * The original version of this source code and documentation is copyrighted   *
 * and owned by IBM, These materials are provided under terms of a License     *
 * Agreement between IBM and Sun. This technology is protected by multiple     *
 * US and International patents. This notice and attribution to IBM may not    *
 * to removed.                                                                 *
 *******************************************************************************
 */

package jdk1_6.sun.text.normalizer;

/**
 * <p>Selection constants for Unicode properties. </p>
 * <p>These constants are used in functions like
 * UCharacter.hasBinaryProperty(int) to select one of the Unicode properties.
 * </p>
 * <p>The properties APIs are intended to reflect Unicode properties as
 * defined in the Unicode Character Database (UCD) and Unicode Technical
 * Reports (UTR).</p>
 * <p>For details about the properties see <a href=http://www.unicode.org>
 * http://www.unicode.org</a>.</p>
 * <p>For names of Unicode properties see the UCD file PropertyAliases.txt.
 * </p>
 * <p>Important: If ICU is built with UCD files from Unicode versions below
 * 3.2, then properties marked with "new" are not or not fully
 * available. Check UCharacter.getUnicodeVersion() to be sure.</p>
 * @author Syn Wee Quek
 * @stable ICU 2.6
 * @see com.ibm.icu.lang.UCharacter
 */
public interface UProperty
{
    // public data member --------------------------------------------------

    /**
     * Enumerated property Hangul_Syllable_Type, new in Unicode 4.
     * Returns HangulSyllableType values.
     * @stable ICU 2.6
     */
    public static final int HANGUL_SYLLABLE_TYPE = 0x100B;

    /**
     * Bitmask property General_Category_Mask.
     * This is the General_Category property returned as a bit mask.
     * When used in UCharacter.getIntPropertyValue(c),
     * returns bit masks for UCharacterCategory values where exactly one bit is set.
     * When used with UCharacter.getPropertyValueName() and UCharacter.getPropertyValueEnum(),
     * a multi-bit mask is used for sets of categories like "Letters".
     * @stable ICU 2.4
     */
    public static final int GENERAL_CATEGORY_MASK = 0x2000;
}
