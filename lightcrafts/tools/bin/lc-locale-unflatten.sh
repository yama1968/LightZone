#!/bin/sh
#
# Unmarshal Java properties files that have been flattened by
# lc-locale-flatten.sh, taking the flattened form from standard input.
#
# Usage:
#
#     cat (flat-properties) | lc-locale-unflatten.sh (locale)
#
# where (flat-properties) is a flattened properties collection generated by
# lc-locale-flatten.sh and (locale) is the two-letter language abbreviation
# for the ouptut properties file names.
#
# Be sure to check that the encoding of (flat-properties) is ISO 8859-1
# ("Latin 1").  If it is not, then convert it first using native2ascii.
#
# Flattened properties files are used to provide readability for human
# translators.  They are not part of the LightZone build.

if [ $# -ne 1 ]; then
    echo "usage: cat (flat-properties) | lc-locale-unflatten.sh (locale)"
    exit -1
fi
locale=$1
echo using locale \"$1\"

# These markers bracket the original properties file names
# (escaped for regex interpretation in csplit and sed below):
separatorPre='# \*\*\* flattened from'
separatorPost='\*\*\*'

tempdir=locale-unflatten

mkdir $tempdir
cd $tempdir
# skip the first line, containing the revision stamp:
tail +2 | \
# split into files by the separators:
csplit -s -k - "/$separatorPre .* $separatorPost/" '{1000000}'
cd ..

for split in $tempdir/*; do
    file=`head -1 $split | sed "s/$separatorPre \(.*\) $separatorPost/\1/"`
    dir=`dirname $file`
    name=`basename -s .properties $file`_$locale.properties
    dir=`dirname $file`
    mkdir -p $dir 2>&1 > /dev/null
    tail +2 $split > $dir/$name
done

rm -rf $tempdir
