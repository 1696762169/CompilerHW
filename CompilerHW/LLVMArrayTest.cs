using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LLVMSharp;

namespace CompilerHW
{
    internal static class LLVMArrayTest
    {
        public static void Test()
        {
            //    LLVMModuleRef module = LLVM.ModuleCreateWithName("test");
            //    LLVMBuilderRef builder = LLVM.CreateBuilder();

            //    LLVMTypeRef type = LLVM.Int32Type();

            //    LLVMValueRef func = LLVM.AddFunction(module, "main", LLVM.FunctionType(type, new LLVMTypeRef[] { }, false));

            //    LLVMBasicBlockRef entry =  LLVM.AppendBasicBlock(func, "entry");
            //    LLVM.PositionBuilderAtEnd(builder, entry);

            //    LLVMValueRef array = LLVM.AddGlobal(module, LLVM.ArrayType(type, 10), "array");
            //    //LLVMValueRef array = LLVM.BuildAlloca(builder, LLVM.ArrayType(type, 10), "array");
            //    LLVMValueRef[] indices = new LLVMValueRef[] { LLVM.ConstInt(type, 0, false) };
            //    LLVMValueRef ptr = LLVM.BuildGEP(builder, array, indices, "ptr");
            //    //LLVMValueRef ptr = LLVM.BuildGEP(builder, array, new[] { LLVM.ConstInt(LLVM.Int32Type(), 0, false)}, "ptr");

        }
    }
}
