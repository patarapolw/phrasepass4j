# PhrasePass

Passphrase-based password generator for Kotlin. I plan to install this for KeePassDX on Android.

## Installation

- Run `gradle jar` to build the jar, and copy the jar to `libs/` of your project.
- Add `compile fileTree(include: ['*.jar'], dir: 'libs')` to dependency section of `build.gradle`

## Usage

```kotlin
import phrasepass.PhrasePass
println(PhrasePass().nextPassword())
```

You can also define your own rules

```kotlin
import phrasepass.Rules
println(PhrasePass().nextPassword(Rules(
    nWords = 7,
    nPunctuations = 3,
    nDigits = 3
)))
```

Example passwords

```commandline
:Shucking?Obsession4Survive2ManlyPod
1Pectin9Showbiz%Encircle|FootsieFiller
Plural)Untrimmed;Cogwheel1RockinessEarthy1
@Broadly7Macaroni7SpousalRely|Wobbly
5ColonizeFilterQuery_Errand{Humorous2
```
