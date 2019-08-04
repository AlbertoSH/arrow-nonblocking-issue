# Λrrow-kt NonBlocking issue reproducer

Small project reproducing an issue in [Λrrow](https://arrow-kt.io/)

## Issue

When using the new `fx` component, `NonBlocking.parMapN` computes each effect in parallel as expected. However, `NonBlocking.parTraverse`
(and, therefore, `NonBlocking.parSequence`) performs in a sequential way

## Specific example

Running 3 effects consisting in `delay(1000)`. `parMapN` finishes in around 1s while `parSequence` requires around 3s.
Tests are provided in order to assert that the execution takes the expected time

## Λrrow version

Both `0.9.0` and `0.10.0-SNAPSHOT` (at the time of writing this file) are affected
