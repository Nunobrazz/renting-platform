#!/bin/bash

echo -e "Building dar...\n"
daml build -o ./rentingPlatform.dar
echo -e "\n\nGenerating Java Code dar...\n"
daml codegen java rentingPlatform.dar=rentingPlatform.codegen --output-directory Time/src/main/java/
daml codegen java rentingPlatform.dar=rentingPlatform.codegen --output-directory Arbitrators/src/main/java/
daml codegen java rentingPlatform.dar=rentingPlatform.codegen --output-directory User/src/main/java/
echo -e "\n\nStarting Sandbox with...\n"
daml start;

