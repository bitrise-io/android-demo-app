# Multi Module AAR Sample (SSW-3065 e2e fixture)

Nested library modules where two modules share the basename `data`
(the layout from bitrise-io/go-android#67): `./gradlew assembleDebug`
produces three same-or-similarly named AARs under each module's
`build/outputs/aar/`. Used by the steps-gradle-runner e2e to verify
that same-named artifacts survive the deploy-dir collision and that
the artifact map accounts for AARs.
