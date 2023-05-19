using LLVMSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LLVMSharp.Interop;

namespace CompilerHW
{
    /// <summary>
    /// 符号表类
    /// </summary>
    internal class SymbolTable
    {
        private readonly Stack<Dictionary<string, (LLVMValueRef value, LLVMTypeRef type)>> m_ScopeStack = new();
        public SymbolTable()
        {
            // 初始时就有一个全局符号表
            m_ScopeStack.Push(new Dictionary<string, (LLVMValueRef, LLVMTypeRef)>());
        }

        /// <summary>
        /// 进入新作用域
        /// </summary>
        public void EnterScope()
        {
            m_ScopeStack.Push(new Dictionary<string, (LLVMValueRef, LLVMTypeRef)>());
        }
        /// <summary>
        /// 离开作用域
        /// </summary>
        public void ExitScope()
        {
            m_ScopeStack.Pop();
        }

        /// <summary>
        /// 添加符号
        /// </summary>
        public void AddSymbol(string name, LLVMValueRef value, LLVMTypeRef type)
        {
            m_ScopeStack.Peek()[name] = (value, type);
        }

        /// <summary>
        /// 在所有符号表中获取符号
        /// </summary>
        public LLVMValueRef GetValue(string name)
        {
            foreach (var scope in m_ScopeStack)
            {
                if (scope.TryGetValue(name, out var symbol))
                {
                    return symbol.value;
                }
            }
            return new LLVMValueRef(IntPtr.Zero);
        }
        /// <summary>
        /// 在最上层的符号表中获取符号
        /// </summary>
        /// <param name="name"></param>
        /// <returns></returns>
        public LLVMValueRef GetValueInTop(string name)
        {
            return m_ScopeStack.Peek().TryGetValue(name, out var symbol) ? symbol.value : new LLVMValueRef(IntPtr.Zero);
        }

        /// <summary>
        /// 在所有符号表中获取符号的类型
        /// </summary>
        public LLVMTypeRef GetType(string name)
        {
            foreach (var scope in m_ScopeStack)
            {
                if (scope.TryGetValue(name, out var symbol))
                {
                    return symbol.type;
                }
            }
            return new LLVMTypeRef(IntPtr.Zero);
        }
    }
}
