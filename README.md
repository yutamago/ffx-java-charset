Java `Charset` and `CharsetProvider` for Final Fantasy X
===========================================

To be used with Ghidra.

This project is an implementation of `CharsetProvider` and `Charset`.
It currently contains a charset for Final Fantasy X's strings, and is
intended for Ghidra.

# Getting started
- Drop the jar file into Ghidra's `Ghidra/patch` directory.
- After you drop the .jar into Ghidra, you can right click on a string, select Data -> Settings... or Data -> Default Settings..., and pick your new encoding from the Charset list.

See https://github.com/NationalSecurityAgency/ghidra/issues/2714#issuecomment-1162242324
